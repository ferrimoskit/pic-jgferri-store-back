package com.jgferri.pic_store_backend.controllers;

import com.jgferri.pic_store_backend.domain.user.User;
import com.jgferri.pic_store_backend.dtos.UserDTO;
import com.jgferri.pic_store_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/customers")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO customer){
        User newUser = userService.createUser(customer);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.getAllCustomers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


}
