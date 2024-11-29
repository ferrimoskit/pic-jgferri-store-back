package com.jgferri.pic_store_backend.dtos;

import com.jgferri.pic_store_backend.domain.user.UserType;

public record UserDTO(String name, String username, UserType userType) {
}
