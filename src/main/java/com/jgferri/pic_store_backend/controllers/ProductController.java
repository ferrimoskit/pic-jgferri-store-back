package com.jgferri.pic_store_backend.controllers;


import com.jgferri.pic_store_backend.domain.product.Product;
import com.jgferri.pic_store_backend.dtos.ProductDTO;
import com.jgferri.pic_store_backend.respositories.ProductRepository;
import com.jgferri.pic_store_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;
    @Autowired
    ProductRepository repository;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = this.service.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO product){
        System.out.println("Product " + product);
        Product newProduct = new Product(product);
        System.out.println("newProduct " + product);
        this.saveProduct(newProduct);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);

    }

    private void saveProduct(Product product) {
        System.out.println("Saving product " + product);
        this.repository.save(product);
    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id){
        return this.repository.findProductById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProductById(@PathVariable Long id, @RequestBody ProductDTO product){
        Optional<Product> existingProductOptional = this.repository.findProductById(id);
        if(existingProductOptional.isEmpty()) {return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        Product existingProduct = existingProductOptional.get();
        existingProduct.setName(product.name());
        existingProduct.setActive(product.active());
        existingProduct.setAvailable(product.available());
        existingProduct.setOffer(product.offer());
        existingProduct.setPicture(product.picture());
        existingProduct.setDescription(product.description());
        existingProduct.setPrice(product.price());
        this.repository.save(existingProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
