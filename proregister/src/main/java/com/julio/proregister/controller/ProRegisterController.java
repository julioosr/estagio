package com.julio.proregister.controller;

import com.julio.proregister.DTO.LoginRequestDTO;
import com.julio.proregister.repository.UsuarioRepository;
import com.julio.proregister.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proregister")
@RequiredArgsConstructor
public class ProRegisterController {
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {

    }

}
