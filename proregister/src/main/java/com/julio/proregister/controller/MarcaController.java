package com.julio.proregister.controller;

import com.julio.proregister.model.Marca;
import com.julio.proregister.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
@CrossOrigin("*")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    // Listar todas as marcas
    @GetMapping
    public List<Marca> getAllMarcas() {
        return marcaRepository.findAll();
    }

    // Buscar marca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable Integer id) {
        Optional<Marca> marca = marcaRepository.findById(id);
        return marca.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar uma nova marca
    @PostMapping
    public ResponseEntity<Marca> createMarca(@RequestBody Marca marca) {
        Marca novaMarca = marcaRepository.save(marca);
        return new ResponseEntity<>(novaMarca, HttpStatus.CREATED);
    }

    // Atualizar uma marca existente
    @PutMapping("/{id}")
    public ResponseEntity<Marca> updateMarca(@PathVariable Integer id, @RequestBody Marca marcaAtualizada) {
        return marcaRepository.findById(id).map(marca -> {
            marca.setDescricao(marcaAtualizada.getDescricao());
            marcaRepository.save(marca);
            return ResponseEntity.ok(marca);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir uma marca
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Integer id) {
        if (marcaRepository.existsById(id)) {
            marcaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
