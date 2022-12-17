package com.codegym.demospringboot.validate;

import com.codegym.demospringboot.bean.Product;
import com.codegym.demospringboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class Validate implements Validator {
    @Autowired
    IProductService productService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        Date date = new Date();
        if(product.getDatePublish() == null){
            errors.rejectValue("datePublish", "", null, "Ngày ra sản phẩm không được để trống");
        }
        if(date.before(product.getDatePublish())){
            errors.rejectValue("datePublish","",null,"Ngày ra sản phẩm không được lớn hơn ngày hiện tại");
        }
        if(productService.findByName(product.getName()).size()!=0){
            errors.rejectValue("name","",null,"Tên sản phẩm không được trùng nhau");
        }

    }
}
