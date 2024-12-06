package com.julio.proregister.repository;

import com.julio.proregister.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {
    @Query("SELECT os FROM OrdemServico os WHERE os.cliente.id = :clienteId")
    List<OrdemServico> findByClienteId(@Param("clienteId") Integer clienteId);
}
