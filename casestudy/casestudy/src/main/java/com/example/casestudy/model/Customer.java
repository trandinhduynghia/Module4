package com.example.casestudy.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Customer type cannot be blank")
    @ManyToOne
    @JoinColumn(name = "customerType")
    CustomerType customerType;

    @NotEmpty(message = "Name cannot be blank")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Birthday cannot be blank")
    private Date birthday;
    @NotNull(message = "Gender cannot be blank")
    private boolean gender;
    @NotEmpty(message = "Card cannot be blank")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Số CMND không hợp lệ")
    private String card;
    @NotEmpty(message = "Phone cannot be blank")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Số điện thoại không hợp lệ")
    private String phone;
    @NotEmpty(message = "Email cannot be blank")
    @Email(message = "Email không hợp lệ")
    private String email;
    @NotEmpty(message = "Address cannot be blank")
    private String address;

    public Customer() {
    }

    public Customer(CustomerType customerType, String name, Date birthday, boolean gender, String card, String phone, String email, String address) {
        this.customerType = customerType;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.card = card;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
//6.Ngày sinh, Ngày làm hợp đồng, Ngày kết thúc sử dụng datepicker để người dùng có thể chọn ngày thuận tiện.
// Phải validate xem ngày giờ có hợp lệ hay không (đúng định dạng ngày giờ theo format DD/MM/YYYY).
// 7.	Số lượng, Số tầng phải là số nguyên dương
// 8.	Lương, Giá, Tiền đặt cọc, Tổng tiền phải là số dương
// 9.	Tính tổng tiền sử dụng dịch vụ (trong màn hình 9) .
// 10.	Khi click vào nút xóa (hoặc biểu tượng xóa) trên các dòng ở các màn hình liệt kê thì phải hiển thị thông báo
// confirm việc người dùng có chắc chắn muốn xóa dữ liệu hay không. Nếu người dùng chọn Yes thì xóa dữ liệu ở dòng đó .

