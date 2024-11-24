package com.jgferri.pic_store_backend.services;

import com.jgferri.pic_store_backend.domain.product.Product;
import com.jgferri.pic_store_backend.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void saveProduct(Product product){
        this.productRepository.save(product);
    }
}
