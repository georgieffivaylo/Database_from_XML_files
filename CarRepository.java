package com.softuni.xml.repositories;

import com.softuni.xml.entities.*;
import org.springframework.data.jpa.repository.*;

public interface CarRepository extends JpaRepository<Car, Long> {

    Car findByMakeAndModel(String make, String model);
}
