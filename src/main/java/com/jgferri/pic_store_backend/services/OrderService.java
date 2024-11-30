package com.jgferri.pic_store_backend.services;

import com.jgferri.pic_store_backend.domain.order.Order;
import com.jgferri.pic_store_backend.respositories.OrderRepository;
import com.jgferri.pic_store_backend.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public void saveOrder(Order order) {this.orderRepository.save(order);}

}
