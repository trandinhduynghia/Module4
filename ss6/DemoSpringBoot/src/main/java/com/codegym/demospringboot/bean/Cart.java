package com.codegym.demospringboot.bean;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cart;
    public Cart() {
        cart = new HashMap<>();
    }
    public Map<Product, Integer> getCart() {
        return cart;
    }
    public boolean checkItemInCart(Product product){
        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }
    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }
    public void addToCart(Product product){
        if(!checkItemInCart(product)){
            cart.put(product,1);
        }else{
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            cart.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public void removeProduct(Product product){
        cart.remove(product);
    }
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }
    public Integer countItemQuantity(){
        return cart.size();
    }
    public Float countTotalPayment(){
        float payment = 0;
        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }
    public int getAmount(Product product){
        return cart.get(product);
    }


}
