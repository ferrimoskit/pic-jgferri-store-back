package com.jgferri.pic_store_backend.domain.user;

import com.jgferri.pic_store_backend.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="users")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column (unique = true)
    private String username;
    private UserType userType;
    private String password;

    public User(UserDTO data) {
        this.name = data.name();
        this.username = data.username();
        this.userType = data.userType();
    }
}
