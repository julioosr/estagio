package com.julio.proregister.controller;

import com.julio.proregister.model.Servico;
import com.julio.proregister.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    // Listar todos os servicos
    @GetMapping
    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }

    // Buscar servico por ID
    @GetMapping("/{servicoID}")
    public ResponseEntity<Servico> getServicoById(@PathVariable Integer servicoID) {
        Optional<Servico> servico = servicoRepository.findById(servicoID);
        return servico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar um novo servico
    @PostMapping
    public Servico createServico(@RequestBody Servico servico) {
        return servicoRepository.save(servico);
    }

    // Atualizar um servico existente
    @PutMapping("/{servicoID}")
    public ResponseEntity<Servico> updateServico(@PathVariable Integer servicoID, @RequestBody Servico servico) {
        if (!servicoRepository.existsById(servicoID)) {
            return ResponseEntity.notFound().build();
        }
        servico.setServicoID(servicoID);
        Servico updatedServico = servicoRepository.save(servico);
        return ResponseEntity.ok(updatedServico);
    }

    // Excluir um servico
    @DeleteMapping("/{servicoID}")
    public ResponseEntity<Void> deleteServico(@PathVariable Integer servicoID) {
        if (!servicoRepository.existsById(servicoID)) {
            return ResponseEntity.notFound().build();
        }
        servicoRepository.deleteById(servicoID);
        return ResponseEntity.noContent().build();
    }
}