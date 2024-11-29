package com.jgferri.pic_store_backend.respositories;

import com.jgferri.pic_store_backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
}
