package com.julio.proregister.repository;


import com.julio.proregister.model.OSItem;
import com.julio.proregister.model.OSItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OSItemRepository extends JpaRepository<OSItem, OSItemId> {

}