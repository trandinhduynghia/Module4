package com.example.module6.restcontroller;

import com.example.module6.model.Account;
import com.example.module6.model.Customer;
import com.example.module6.model.ResetPassRequest;
import com.example.module6.model.SignupRequest;
import com.example.module6.service.AccountService;
import com.example.module6.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*")
public class RestRegisterController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private HttpSession session;

    @PostMapping("/signup")
    public ResponseEntity<?> registerCustomer(@RequestBody SignupRequest signupRequest){
        if(accountService.existsByUserName(signupRequest.getUsername()) != null){
            return ResponseEntity.badRequest().body("Tên đăng nhập đã được đăng ký!");
        }
        Account account = new Account(signupRequest.getUsername(),signupRequest.getPassword());
        accountService.save(account);
        Customer customer = new Customer(
                signupRequest.getFullName(),
                signupRequest.getBirthday(),
                signupRequest.isGender(),
                signupRequest.getCardId(),
                signupRequest.getEmail(),
                signupRequest.getAddress(),
                signupRequest.getPhoneNumber(),
                account
        );
        customerService.save(customer);
        return ResponseEntity.ok("Đăng ký tài khoản thành công!");
    }

    @PostMapping("/do-reset-password")
    public ResponseEntity<?> doResetPassword(@RequestBody ResetPassRequest resetPassRequest) {
        if(accountService.existsByPassword(resetPassRequest.getUsername(), resetPassRequest.getOldPassword()) != null){
            accountService.saveNewPassword(resetPassRequest.getNewPassword(), resetPassRequest.getUsername());
            return ResponseEntity.ok(("Cập nhật mật khẩu thành công!"));
        }
        return ResponseEntity.badRequest().body("Mật khẩu cũ không đúng!");
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> findTaiKhoanById(@PathVariable Integer id) {
//        Optional<Customer> taiKhoanOptional = taiKhoanService.findById(id);
//        if (!taiKhoanOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(taiKhoanOptional.get(), HttpStatus.OK);
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<Void> saveTaiKhoan(@RequestBody Customer taiKhoan) {
//        taiKhoanService.save(taiKhoan);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
//
//    }
//
//    @PutMapping("edit/{id}")
//    public ResponseEntity<Void> updateTaiKhoan(@PathVariable Integer id, @RequestBody Customer taiKhoan) {
//        Optional<Customer> taiKhoanOptional = taiKhoanService.findById(id);
//        if (!taiKhoanOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        taiKhoan.setId(taiKhoanOptional.get().getId());
//        taiKhoanService.save(taiKhoan);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        return new ResponseEntity<Void>(httpHeaders, HttpStatus.OK);
//    }
}
