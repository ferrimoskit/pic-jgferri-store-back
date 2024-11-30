package com.jgferri.pic_store_backend.respositories;

import com.jgferri.pic_store_backend.domain.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
