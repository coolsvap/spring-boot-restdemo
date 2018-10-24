package com.example.coolsvap.restdemo.controller;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.coolsvap.restdemo.model.Product;


import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {

    public static Map<String, Product> productRepo = new HashMap<>();

    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }

    @RequestMapping(value = "/products")
    @GetMapping("/products")
    public ResponseEntity<Object> getProduct() {

        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}")
    @GetMapping("/products")
    public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {

        return new ResponseEntity<>(productRepo.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    @GetMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    @GetMapping("/products")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id,  @RequestBody Product product){
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    @GetMapping("/products")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id){
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
}