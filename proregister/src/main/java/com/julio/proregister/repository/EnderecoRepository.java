package com.julio.proregister.repository;

import com.julio.proregister.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    @Query(value = "select * from endereco where cliente = ?", nativeQuery = true)
    public Endereco findByCliente(Integer id);
}
