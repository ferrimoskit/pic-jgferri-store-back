package com.jgferri.pic_store_backend.services;

import com.jgferri.pic_store_backend.domain.user.User;
import com.jgferri.pic_store_backend.dtos.UserDTO;
import com.jgferri.pic_store_backend.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public User findUserById(Long id) throws Exception{
        return this.repository.findUserById(id).orElseThrow(()-> new Exception("Nenhum cliente encontrado"));
    }

    public User createUser(@RequestBody UserDTO user) {
        User newUser = new User(user);
        this.saveUser(newUser);
        return newUser;
    }

    private void saveUser(User user) {this.repository.save(user);}
    public List<User> getAllCustomers(){ return this.repository.findAll();}
}

