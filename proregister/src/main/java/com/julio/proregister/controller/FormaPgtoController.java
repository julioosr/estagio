package com.julio.proregister.controller;

import com.julio.proregister.model.FormaPgto;
import com.julio.proregister.repository.FormaPgtoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class FormaPgtoController {

    @Autowired
    private FormaPgtoRepository formaPgtoRepository;

    // Listar todas as formas de pagamento
    @GetMapping
    public List<FormaPgto> getAllFormasPagamento() {
        return formaPgtoRepository.findAll();
    }

    // Buscar forma de pagamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<FormaPgto> getFormaPagamentoById(@PathVariable Integer id) {
        Optional<FormaPgto> formaPgto = formaPgtoRepository.findById(id);
        return formaPgto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar uma nova forma de pagamento
    @PostMapping
    public ResponseEntity<FormaPgto> createFormaPagamento(@RequestBody FormaPgto formaPgto) {
        FormaPgto novaFormaPgto = formaPgtoRepository.save(formaPgto);
        return new ResponseEntity<>(novaFormaPgto, HttpStatus.CREATED);
    }

    // Atualizar uma forma de pagamento existente
    @PutMapping("/{id}")
    public ResponseEntity<FormaPgto> updateFormaPagamento(@PathVariable Integer id, @RequestBody FormaPgto formaPgtoAtualizada) {
        return formaPgtoRepository.findById(id).map(formaPgto -> {
            formaPgto.setDescricao(formaPgtoAtualizada.getDescricao());
            formaPgtoRepository.save(formaPgto);
            return ResponseEntity.ok(formaPgto);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir uma forma de pagamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormaPagamento(@PathVariable Integer id) {
        if (formaPgtoRepository.existsById(id)) {
            formaPgtoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
