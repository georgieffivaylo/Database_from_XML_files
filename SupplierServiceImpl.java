package com.softuni.xml.services.impls;

import com.softuni.xml.dtos.*;
import com.softuni.xml.entities.*;
import com.softuni.xml.repositories.*;
import com.softuni.xml.services.*;
import com.softuni.xml.utils.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.validation.*;
import java.util.*;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Random random) {
        this.supplierRepository = supplierRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = random;
    }

    @Override
    public void seedSuppliers(List<SupplierSeedDto> supplierSeedDtos) {
        supplierSeedDtos.forEach(s -> {

            if (this.validationUtil.isValid(s)) {
                Supplier supplier = this.supplierRepository.findByName(s.getName());

                if (supplier == null) {
                    supplier = this.modelMapper.map(s, Supplier.class);
                    this.supplierRepository.saveAndFlush(supplier);
                } else {
                    System.out.println("Already in DB !");
                }

            } else {
                this.validationUtil.getConstraintViolations(s).stream()
                        .map(ConstraintViolation::getMessage).forEach(System.out::println);
            }

        });
    }

    @Override
    public Supplier getByRandomId() {
        int randomId = this.random.nextInt((int) this.supplierRepository.count());
        return this.supplierRepository.getById((long) randomId);

    }
}
