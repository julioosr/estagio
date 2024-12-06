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
@RequestMapping("/ordemservico")
@CrossOrigin("*")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    // Listar todas as ordens de serviço
    @GetMapping
    public List<OrdemServico> getAllOrdemServicos() {
        return ordemServicoRepository.findAll();
    }

    // Buscar ordens de serviço por cliente
    @GetMapping("/cliente")
    public ResponseEntity<List<OrdemServico>> buscarPorCliente(@RequestParam Integer clienteId) {
        List<OrdemServico> ordens = ordemServicoRepository.findByClienteId(clienteId);
        if (ordens.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 se não houver ordens
        }
        return ResponseEntity.ok(ordens); // Retorna a lista de ordens com status 200
    }

    // Buscar ordem de serviço por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> getOrdemServicoById(@PathVariable Integer id) {
        Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);
        return ordemServico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar uma nova ordem de serviço
    @PostMapping
    public ResponseEntity<OrdemServico> createOrdemServico(@RequestBody OrdemServico ordemServico) {
        OrdemServico novaOrdemServico = ordemServicoRepository.save(ordemServico);
        return new ResponseEntity<>(novaOrdemServico, HttpStatus.CREATED);
    }

    // Atualizar uma ordem de serviço existente
    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> updateOrdemServico(@PathVariable Integer id, @RequestBody OrdemServico ordemServicoAtualizada) {
        return ordemServicoRepository.findById(id).map(ordemServico -> {
            ordemServico.setDataAgenda(ordemServicoAtualizada.getDataAgenda());
            ordemServico.setHorario(ordemServicoAtualizada.getHorario());
            ordemServico.setDataRealizada(ordemServicoAtualizada.getDataRealizada());
            ordemServico.setTotal(ordemServicoAtualizada.getTotal());
            ordemServico.setCliente(ordemServicoAtualizada.getCliente());
            ordemServico.setVeiculo(ordemServicoAtualizada.getVeiculo());
            ordemServico.setUsuario(ordemServicoAtualizada.getUsuario());
            ordemServico.setServico(ordemServicoAtualizada.getServico());
            ordemServicoRepository.save(ordemServico);
            return ResponseEntity.ok(ordemServico);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir uma ordem de serviço
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdemServico(@PathVariable Integer id) {
        if (ordemServicoRepository.existsById(id)) {
            ordemServicoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
