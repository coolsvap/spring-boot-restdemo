package com.example.coolsvap.restdemo.controller;

import com.example.coolsvap.restdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ConsumeWebService {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/template/products")
    public String getProductList(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
        return restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, httpEntity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
    public String createProducts(@RequestBody Product product){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> httpEntity = new HttpEntity<Product>(product, httpHeaders);
        return restTemplate.exchange("http://localhost:8080/products", HttpMethod.POST, httpEntity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.PUT)
    public String updateProducts(@PathVariable("id") String id,  @RequestBody Product product){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> httpEntity = new HttpEntity<Product>(product, httpHeaders);
        return restTemplate.exchange("http://localhost:8080/products/" + id, HttpMethod.PUT, httpEntity, String.class).getBody();
    }

    @RequestMapping(value = "/template/products/{id}", method = RequestMethod.DELETE)
    public String deleteProducts(@PathVariable("id") String id,  @RequestBody Product product){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> httpEntity = new HttpEntity<Product>(httpHeaders);
        return restTemplate.exchange("http://localhost:8080/products/" + id, HttpMethod.DELETE, httpEntity, String.class).getBody();
    }
}
