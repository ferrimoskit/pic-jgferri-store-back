package com.jgferri.pic_store_backend.respositories;

import com.jgferri.pic_store_backend.domain.order.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct,Long> {

}
