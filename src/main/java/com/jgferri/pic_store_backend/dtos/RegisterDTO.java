package com.jgferri.pic_store_backend.dtos;

import com.jgferri.pic_store_backend.domain.user.UserType;

public record RegisterDTO(String username, String password, UserType type) {
}
