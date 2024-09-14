package com.julio.proregister.repository;

import com.julio.proregister.model.FormaPgto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPgtoRepository extends JpaRepository<FormaPgto, Integer> {

}