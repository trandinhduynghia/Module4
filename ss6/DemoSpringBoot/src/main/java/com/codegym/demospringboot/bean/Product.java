package com.codegym.demospringboot.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 5, max = 50, message = "Tên sản phẩm dài 5 - 50 kí tự")
    private String name;

    @Min(value = 500000, message = "Giá phải lớn hơn 500000")
    private Double price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePublish;

    @Size(min = 5, max = 50, message = "Mô tả dài 5 - 50 kí tự")
    private String description;

    @ManyToOne
    @JoinColumn(name = "productType")
    ProductType productType;

    public Product() {
    }

    public Product(String name, Double price, Date datePublish, String description, ProductType productType) {
        this.name = name;
        this.price = price;
        this.datePublish = datePublish;
        this.description = description;
        this.productType = productType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(Date datePublish) {
        this.datePublish = datePublish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
