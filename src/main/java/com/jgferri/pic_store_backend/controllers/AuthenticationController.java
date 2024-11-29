package com.jgferri.pic_store_backend.controllers;

import com.jgferri.pic_store_backend.domain.user.User;
import com.jgferri.pic_store_backend.dtos.AuthenticationDTO;
import com.jgferri.pic_store_backend.dtos.LoginResponseDTO;
import com.jgferri.pic_store_backend.dtos.RegisterDTO;
import com.jgferri.pic_store_backend.infra.security.TokenService;
import com.jgferri.pic_store_backend.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO data){
        if(this.repository.findByUsername(data.username()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User();
        newUser.setUsername(data.username());
        newUser.setPassword(encryptedPassword);
        newUser.setUserType(data.type());
        newUser.setName(data.username());

        this.repository.save(newUser);

       return ResponseEntity.ok().build();
    }
}
