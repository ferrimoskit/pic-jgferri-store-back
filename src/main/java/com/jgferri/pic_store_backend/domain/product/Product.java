package com.jgferri.pic_store_backend.domain.product;

import com.jgferri.pic_store_backend.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="products")
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean active;
    private Boolean available;
    private Boolean offer;
    private BigDecimal price;
    private String picture;

    public Product(ProductDTO data){
        this.name = data.name();
        this.description = data.description();
        this.active = data.active();
        this.available = data.available();
        this.offer = data.offer();
        this.price = data.price();
        this.picture = data.picture();
    }
}
