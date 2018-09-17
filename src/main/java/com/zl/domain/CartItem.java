package com.zl.domain;

public class CartItem {

    // 商品对象，使用Product对象
    private Product product;
    // 商品数量
    private Integer count;
    // 商品小计，价格=数量*单价
    private double subtotal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    // 内部计算价格
    public double getSubtotal() {
        // 商品的单价*数量
        return product.getShop_price() * count;
    }
	/*public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}*/
}
