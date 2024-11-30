package com.jgferri.pic_store_backend.controllers;

import com.jgferri.pic_store_backend.domain.order.Order;
import com.jgferri.pic_store_backend.domain.order.OrderProduct;
import com.jgferri.pic_store_backend.dtos.OrderDTO;
import com.jgferri.pic_store_backend.dtos.OrderProductDTO;
import com.jgferri.pic_store_backend.respositories.OrderProductRepository;
import com.jgferri.pic_store_backend.respositories.OrderRepository;
import com.jgferri.pic_store_backend.respositories.ProductRepository;
import com.jgferri.pic_store_backend.services.OrderService;
import com.jgferri.pic_store_backend.services.ProductService;
import com.jgferri.pic_store_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService service;
    @Autowired
    OrderRepository repository;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO order) throws Exception {
        Order newOrder = new Order();
        newOrder.setDeliveryAddress(order.deliveryAddress());
        newOrder.setUser(userService.findUserById(order.user()));
        newOrder.setOrderDate(LocalDateTime.now());
        System.out.println(order);
        List<OrderProduct> orderProducts = new ArrayList<>();
        order.products().forEach(product -> {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(newOrder);
            orderProduct.setProduct(productService.getProductById(product.productId()));
            orderProduct.setQuantity(product.quantity());
            System.out.println(orderProduct);
            orderProducts.add(orderProduct);

        });
        newOrder.setOrderProducts(orderProducts);

        this.repository.save(newOrder);
        return ResponseEntity.ok().build();
    }
}
