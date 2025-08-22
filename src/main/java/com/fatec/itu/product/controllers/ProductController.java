package com.fatec.itu.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.itu.product.entities.Product;
import com.fatec.itu.product.repositories.ProductRepository;

@RestController
@RequestMapping("products")
public class ProductController {
    
    @Autowired
    private ProductRepository repository;
    //metodo
    //retorna todos os produtos cadastrados no banco -- repositorio
    @GetMapping
    public List<Product> getProducts(){

    return repository.findAll();

    
   }


}
