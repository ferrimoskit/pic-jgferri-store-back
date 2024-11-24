package com.jgferri.pic_store_backend.domain.customer;

import com.jgferri.pic_store_backend.dtos.CustomerDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="customers")
@Table(name="customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column (unique = true)
    private String username;

    public Customer(CustomerDTO data) {
        this.name = data.name();
        this.username = data.username();
    }
}
