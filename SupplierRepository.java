package com.softuni.xml.repositories;

import com.softuni.xml.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier findByName(String name);

    Supplier getById(Long id);
}
