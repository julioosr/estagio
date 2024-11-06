package com.julio.proregister.controller;

import com.julio.proregister.model.Empresa;
import com.julio.proregister.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
@CrossOrigin("*")
public class EmpresaController {
    @Autowired
    private EmpresaRepository empresaRepository;

    // Listar todas as empresas
    @GetMapping
    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    // Buscar empresa por CNPJ
    @GetMapping("/{cnpj}")
    public ResponseEntity<Empresa> getEmpresaByCnpj(@PathVariable String cnpj) {
        Optional<Empresa> empresa = empresaRepository.findById(cnpj);
        return empresa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar uma nova empresa
    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
        Empresa novaEmpresa = empresaRepository.save(empresa);
        return new ResponseEntity<>(novaEmpresa, HttpStatus.CREATED);
    }

    // Atualizar uma empresa existente
    @PutMapping("/{cnpj}")
    public ResponseEntity<Empresa> updateEmpresa(@PathVariable String cnpj, @RequestBody Empresa empresaAtualizada) {
        return empresaRepository.findById(cnpj).map(empresa -> {
            empresa.setNomeFantasia(empresaAtualizada.getNomeFantasia());
            empresa.setRazaoSocial(empresaAtualizada.getRazaoSocial());
            empresa.setEmail(empresaAtualizada.getEmail());
            empresa.setTelefone(empresaAtualizada.getTelefone());
            empresa.setUsuario(empresaAtualizada.getUsuario());
            empresaRepository.save(empresa);
            return ResponseEntity.ok(empresa);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir uma empresa
    @DeleteMapping("/{cnpj}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable String cnpj) {
        if (empresaRepository.existsById(cnpj)) {
            empresaRepository.deleteById(cnpj);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
