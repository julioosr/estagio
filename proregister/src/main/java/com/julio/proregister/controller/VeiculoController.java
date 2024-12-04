package com.julio.proregister.controller;

import com.julio.proregister.model.Endereco;
import com.julio.proregister.model.Veiculo;
import com.julio.proregister.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
@CrossOrigin("*")
public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;

    // Listar todos os veículos
    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    // Buscar veículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable Integer id) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        return veiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Veiculo>> getVeiculosByClienteId(@PathVariable Integer clienteId) {
        List<Veiculo> veiculos = veiculoRepository.findByClienteId(clienteId);
        if (veiculos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(veiculos);
    }

    // Criar um novo veículo
    @PostMapping
    public ResponseEntity<Veiculo> createVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo novoVeiculo = veiculoRepository.save(veiculo);
        return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }

    // Atualizar um veículo existente
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updateVeiculo(@PathVariable Integer id, @RequestBody Veiculo veiculoAtualizado) {
        return veiculoRepository.findById(id).map(veiculo -> {
            veiculo.setModelo(veiculoAtualizado.getModelo());
            veiculo.setAnoDeFabricacao(veiculoAtualizado.getAnoDeFabricacao());
            veiculo.setCor(veiculoAtualizado.getCor());
            veiculo.setPlaca(veiculoAtualizado.getPlaca());
            veiculo.setRenavam(veiculoAtualizado.getRenavam());
            veiculo.setCliente(veiculoAtualizado.getCliente());
            veiculo.setMarca(veiculoAtualizado.getMarca());
            veiculoRepository.save(veiculo);
            return ResponseEntity.ok(veiculo);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir um veículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable Integer id) {
        if (veiculoRepository.existsById(id)) {
            veiculoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
