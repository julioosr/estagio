package com.julio.proregister.controller;

import com.julio.proregister.model.OrdemServico;
import com.julio.proregister.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordens")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    // Listar todas as ordens de serviço
    @GetMapping
    public List<OrdemServico> getAllOrdens() {
        return ordemServicoRepository.findAll();
    }

    // Buscar ordem de serviço por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> getOrdemById(@PathVariable Integer id) {
        Optional<OrdemServico> ordem = ordemServicoRepository.findById(id);
        return ordem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar uma nova ordem de serviço
    @PostMapping
    public ResponseEntity<OrdemServico> createOrdem(@RequestBody OrdemServico ordemServico) {
        OrdemServico novaOrdem = ordemServicoRepository.save(ordemServico);
        return new ResponseEntity<>(novaOrdem, HttpStatus.CREATED);
    }

    // Atualizar uma ordem de serviço existente
    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> updateOrdem(@PathVariable Integer id, @RequestBody OrdemServico ordemAtualizada) {
        return ordemServicoRepository.findById(id).map(ordem -> {
            ordem.setDataAgenda(ordemAtualizada.getDataAgenda());
            ordem.setHorario(ordemAtualizada.getHorario());
            ordem.setDataRealizada(ordemAtualizada.getDataRealizada());
            ordem.setTotal(ordemAtualizada.getTotal());
            ordem.setCliente(ordemAtualizada.getCliente());
            ordem.setVeiculo(ordemAtualizada.getVeiculo());
            ordem.setUsuario(ordemAtualizada.getUsuario());
            ordemServicoRepository.save(ordem);
            return ResponseEntity.ok(ordem);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir uma ordem de serviço
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdem(@PathVariable Integer id) {
        if (ordemServicoRepository.existsById(id)) {
            ordemServicoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
