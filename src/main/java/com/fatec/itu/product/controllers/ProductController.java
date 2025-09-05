package com.fatec.itu.product.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatec.itu.product.entities.Product;
import com.fatec.itu.product.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
    //injeta o repositorio 
    @Autowired
    private ProductService service;
    //metodo
    //retorna todos os produtos cadastrados no banco -- repositorio
    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){

    return ResponseEntity.ok(service.getAllProducts());

    
   }
//atraves dele que eu devolvo o status code correto
   @GetMapping("{id}")
public ResponseEntity<Product> getProductById(@PathVariable long id) {
        return ResponseEntity.ok(service.getProductById(id));
}

@DeleteMapping("{id}")
public ResponseEntity<Void> deleteProductById(@PathVariable long id)
{
     service.deleteProductById(id);
     return ResponseEntity.noContent().build();
}

//nivel de maturidade 2 -- post
 @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product)//indica que os dados vem do http do metodo post -- recebe os dados do produto que quero salvar
    {
        Product newProduct = service.saveProduct(product);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newProduct.getId())
                .toUri();
        return ResponseEntity.created(location)
                             .body(newProduct);
    }

      @PutMapping("{id}")
    public ResponseEntity<Void> updateProduct( @PathVariable long id,
                                               @RequestBody Product product
                                              )
    {
        service.updateProduct(product, id);
        return ResponseEntity.noContent().build();
    }


}
