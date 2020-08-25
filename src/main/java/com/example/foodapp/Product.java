package com.example.foodapp;

public class Product {
    private int id;
    private String productname;
    private String productprice;

    public Product(int id, String productname, String productprice) {
        this.id = id;
        this.productname = productname;
        this.productprice = productprice;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }
}
