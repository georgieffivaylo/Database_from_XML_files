package com.softuni.xml.repositories;

import com.softuni.xml.entities.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

    Part getByName(String name);

    Part getById(Long id);
}
