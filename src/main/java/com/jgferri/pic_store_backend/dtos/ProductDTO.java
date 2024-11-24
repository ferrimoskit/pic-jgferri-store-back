package com.jgferri.pic_store_backend.dtos;

import java.math.BigDecimal;

public record ProductDTO(String name, Boolean active, Boolean offer, Boolean available, BigDecimal price, String picture, String description) {
}
