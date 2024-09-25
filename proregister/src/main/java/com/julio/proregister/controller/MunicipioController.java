package com.julio.proregister.controller;

import com.julio.proregister.model.Municipio;
import com.julio.proregister.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {

    @Autowired
    private MunicipioRepository municipioRepository;

    // Listar todos os municípios
    @GetMapping
    public List<Municipio> getAllMunicipios() {
        return municipioRepository.findAll();
    }

    // Buscar município por ID
    @GetMapping("/{id}")
    public ResponseEntity<Municipio> getMunicipioById(@PathVariable Integer id) {
        Optional<Municipio> municipio = municipioRepository.findById(id);
        return municipio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar um novo município
    @PostMapping
    public ResponseEntity<Municipio> createMunicipio(@RequestBody Municipio municipio) {
        Municipio novoMunicipio = municipioRepository.save(municipio);
        return new ResponseEntity<>(novoMunicipio, HttpStatus.CREATED);
    }

    // Atualizar um município existente
    @PutMapping("/{id}")
    public ResponseEntity<Municipio> updateMunicipio(@PathVariable Integer id, @RequestBody Municipio municipioAtualizado) {
        return municipioRepository.findById(id).map(municipio -> {
            municipio.setNome(municipioAtualizado.getNome());
            municipio.setUf(municipioAtualizado.getUf());
            municipioRepository.save(municipio);
            return ResponseEntity.ok(municipio);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir um município
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMunicipio(@PathVariable Integer id) {
        if (municipioRepository.existsById(id)) {
            municipioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
