package com.julio.proregister.controller;

import com.julio.proregister.model.Endereco;
import com.julio.proregister.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Listar todos os endereços
    @GetMapping
    public List<Endereco> getAllEnderecos() {
        return enderecoRepository.findAll();
    }

    // Buscar endereço por ID
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Integer id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar um novo endereço
    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) {
        Endereco novoEndereco = enderecoRepository.save(endereco);
        return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
    }

    // Atualizar um endereço existente
    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Integer id, @RequestBody Endereco enderecoAtualizado) {
        return enderecoRepository.findById(id).map(endereco -> {
            endereco.setCep(enderecoAtualizado.getCep());
            endereco.setRua(enderecoAtualizado.getRua());
            endereco.setComplemento(enderecoAtualizado.getComplemento());
            endereco.setBairro(enderecoAtualizado.getBairro());
            endereco.setNumero(enderecoAtualizado.getNumero());
            endereco.setCliente(enderecoAtualizado.getCliente());
            endereco.setMunicipio(enderecoAtualizado.getMunicipio());
            enderecoRepository.save(endereco);
            return ResponseEntity.ok(endereco);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir um endereço
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Integer id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
