package com.julio.proregister.repository;

import com.julio.proregister.model.Endereco;
import com.julio.proregister.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    List<Veiculo> findByClienteId(Integer clienteId);
}