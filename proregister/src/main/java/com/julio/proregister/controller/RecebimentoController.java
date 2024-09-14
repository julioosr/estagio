package com.julio.proregister.controller;

import com.julio.proregister.model.Recebimento;
import com.julio.proregister.repository.RecebimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recebimentos")
public class RecebimentoController {

    @Autowired
    private RecebimentoRepository recebimentoRepository;

     // Lista todos os recebimentos.
    @GetMapping
    public List<Recebimento> getAllRecebimentos() {
        return recebimentoRepository.findAll();
    }

    // Buscar recebimentos por ID
    @GetMapping("/{recebimentoID}")
    public ResponseEntity<Recebimento> getRecebimentoById(@PathVariable Integer recebimentoID) {
        Optional<Recebimento> recebimento = recebimentoRepository.findById(recebimentoID);
        return recebimento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar um novo recebimento
    @PostMapping
    public Recebimento createRecebimento(@RequestBody Recebimento recebimento) {
        return recebimentoRepository.save(recebimento);
    }

    // Atualizar um recebimento existente
    @PutMapping("/{recebimentoID}")
    public ResponseEntity<Recebimento> updateRecebimento(@PathVariable Integer recebimentoID,
                                                         @RequestBody Recebimento recebimentoDetails) {
        return recebimentoRepository.findById(recebimentoID)
                .map(recebimento -> {
                    recebimento.setData(recebimentoDetails.getData());
                    recebimento.setValor(recebimentoDetails.getValor());
                    recebimento.setDesconto(recebimentoDetails.getDesconto());
                    recebimento.setOs(recebimentoDetails.getOs());
                    recebimento.setFormaPgto(recebimentoDetails.getFormaPgto());
                    recebimento.setUsuario(recebimentoDetails.getUsuario());
                    Recebimento updatedRecebimento = recebimentoRepository.save(recebimento);
                    return ResponseEntity.ok(updatedRecebimento);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir um recebimento
    @DeleteMapping("/{recebimentoID}")
    public ResponseEntity<Void> deleteRecebimento(@PathVariable Integer recebimentoID) {
        // Tenta encontrar o recebimento pelo ID
        Optional<Recebimento> optionalRecebimento = recebimentoRepository.findById(recebimentoID);

        if (optionalRecebimento.isPresent()) {
            // Se encontrado, exclui o recebimento e retorna 204 No Content
            recebimentoRepository.delete(optionalRecebimento.get());
            return ResponseEntity.noContent().build();
        } else {
            // Se não encontrado, retorna 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
}