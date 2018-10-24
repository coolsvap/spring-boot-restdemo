package com.example.coolsvap.restdemo.model;

public class Product {
    public Product(String id, String name) {
        this.id = id;
        Name = name;
    }

    public Product() {

    }

    private String id;
    private String Name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
