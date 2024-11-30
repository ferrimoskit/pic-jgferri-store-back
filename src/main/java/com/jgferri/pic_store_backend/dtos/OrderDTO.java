package com.jgferri.pic_store_backend.dtos;

import java.util.List;

public record OrderDTO(String deliveryAddress, Long user, List<OrderProductDTO> products) {
}
