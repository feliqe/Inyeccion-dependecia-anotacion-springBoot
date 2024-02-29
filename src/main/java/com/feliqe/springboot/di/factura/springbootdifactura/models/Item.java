package com.feliqe.springboot.di.factura.springbootdifactura.models;

public class Item {

    private Product product;
    private Integer quantily;

    public Item() {
    }

    //se crear un construnctor para acceso sin mencionar el set
    public Item(Product product, Integer quantily) {
        this.product = product;
        this.quantily = quantily;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getQuantily() {
        return quantily;
    }
    public void setQuantily(Integer quantily) {
        this.quantily = quantily;
    }

    // calcular el valor del precio mostrando el total
    public int getImporte(){
        return quantily * product.getPrice();
    }
}
