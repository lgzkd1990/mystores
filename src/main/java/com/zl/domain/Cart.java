package com.zl.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Map<String, CartItem> map = new LinkedHashMap<>();
    private double total;//总金额

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public Map<String, CartItem> getMap() {
        return map;
    }

    public  void remove(String key){
        CartItem cartItem = map.remove(key);
        total = total-cartItem.getSubtotal();
    }
    public void clear(){
        map.clear();
        total=0;
    }
    public void add(CartItem cartItem){
        CartItem cartItem1 = map.get(cartItem.getProduct().getPid());
        if (cartItem1 ==null){
            map.put(cartItem1.getProduct().getPid(),cartItem1);
            total=total+cartItem1.getSubtotal();
        }else{
            cartItem1.setCount(cartItem1.getCount()+cartItem1.getCount());
            total=total+cartItem.getSubtotal();
        }
    }
}
