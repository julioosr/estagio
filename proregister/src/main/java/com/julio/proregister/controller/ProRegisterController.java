package com.julio.proregister.controller;

import com.julio.proregister.DTO.LoginRequestDTO;
import com.julio.proregister.DTO.RegisterRequestDTO;
import com.julio.proregister.DTO.ResponseDTO;
import com.julio.proregister.model.Usuario;
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

import java.util.Optional;

@RestController
@RequestMapping("/proregister")
@RequiredArgsConstructor
public class ProRegisterController {
    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        Usuario usuario = this.repository.findByLogin(body.login()).orElseThrow(new RuntimeException("User not found"));
        if(passwordEncoder.matches(usuario.getSenha(), body.Senha())) {
            String token = this.tokenService.generateToken(usuario);
            return ResponseEntity.ok(new ResponseDTO(usuario.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<Usuario> usuario = this.repository.findByLogin(body.login());

        if (usuario.isEmpty()) {
            Usuario newUsuario = new Usuario();
            newUsuario.setSenha(passwordEncoder.encode(body.Senha()));
            newUsuario.setLogin(body.login());
            newUsuario.setNome(body.nome());
            this.repository.save(newUsuario);

            String token = this.tokenService.generateToken(newUsuario);
            return ResponseEntity.ok(new ResponseDTO(newUsuario.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
