package com.fatec.itu.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;//faz o selec da tabela 

import com.fatec.itu.product.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
