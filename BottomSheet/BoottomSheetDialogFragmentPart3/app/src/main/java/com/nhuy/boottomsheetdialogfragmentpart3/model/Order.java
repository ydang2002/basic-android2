package com.nhuy.boottomsheetdialogfragmentpart3.model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private String price;
    private List<Product> listProduct;
    private String deliverAddress;

    public Order(String price, List<Product> listProduct, String deliverAddress) {
        this.price = price;
        this.listProduct = listProduct;
        this.deliverAddress = deliverAddress;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getDeliverAddress() {
        return deliverAddress;
    }

    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    public String getListProductsName(){
        if(listProduct == null || listProduct.isEmpty()){
            return "";
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < listProduct.size(); i++){
            Product product = listProduct.get(i);

            if(stringBuffer.length() > 0){
                stringBuffer.append("\n");
            }
            stringBuffer.append(product.getName());
        }
        return  stringBuffer.toString();
    }

}
