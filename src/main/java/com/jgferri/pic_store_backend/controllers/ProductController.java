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
}
