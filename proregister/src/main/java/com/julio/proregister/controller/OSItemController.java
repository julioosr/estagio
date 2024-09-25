package com.julio.proregister.controller;

import com.julio.proregister.model.OSItem;
import com.julio.proregister.model.OSItemId;
import com.julio.proregister.repository.OSItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordemitem")
public class OSItemController {

    @Autowired
    private OSItemRepository osItemRepository;

    // Listar todas os OSItens
    @GetMapping
    public List<OSItem> getAllOSItems() {
        return osItemRepository.findAll();
    }

    // Buscar OSItens
    @GetMapping("/{servico}/{os}/{usuario}")
    public ResponseEntity<OSItem> getOSItemById(@PathVariable Integer servico,
                                                @PathVariable Integer os,
                                                @PathVariable Integer usuario) {
        OSItemId id = new OSItemId(servico, os, usuario);
        Optional<OSItem> osItem = osItemRepository.findById(id);
        return osItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar uma nova OSItens
    @PostMapping
    public OSItem createOSItem(@RequestBody OSItem osItem) {
        return osItemRepository.save(osItem);
    }

    // Atualizar uma OSItem existente
    @PutMapping("/{servico}/{os}/{usuario}")
    public ResponseEntity<OSItem> updateOSItem(@PathVariable Integer servico,
                                               @PathVariable Integer os,
                                               @PathVariable Integer usuario,
                                               @RequestBody OSItem osItemDetails) {
        OSItemId id = new OSItemId(servico, os, usuario);
        Optional<OSItem> osItem = osItemRepository.findById(id);
        if (osItem.isPresent()) {
            OSItem osItemToUpdate = osItem.get();
            osItemToUpdate.setData(osItemDetails.getData());
            osItemToUpdate.setQuantidade(osItemDetails.getQuantidade());
            osItemToUpdate.setPrecoUnitario(osItemDetails.getPrecoUnitario());
            return ResponseEntity.ok(osItemRepository.save(osItemToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Excluir uma OSItem
    @DeleteMapping("/{servico}/{os}/{usuario}")
    public ResponseEntity<Void> deleteOSItem(@PathVariable Integer servico,
                                             @PathVariable Integer os,
                                             @PathVariable Integer usuario) {
        OSItemId id = new OSItemId(servico, os, usuario);
        if (osItemRepository.existsById(id)) {
            osItemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}