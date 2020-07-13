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
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final SupplierService supplierService;
    private final Random random;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, ValidationUtil validationUtil, SupplierService supplierService, Random random) {
        this.partRepository = partRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.supplierService = supplierService;
        this.random = random;
    }

    @Override
    public void seedParts(PartSeedRootDto partSeedRootDto) {
        if (this.partRepository.count() != 0){
            return;
        }

        partSeedRootDto.getPartSeedDtos().forEach(p -> {

            if (this.validationUtil.isValid(p)){
                if (this.partRepository.getByName(p.getName()) == null){
                    Part part = this.modelMapper.map(p, Part.class);
                    part.setSupplier(this.supplierService.getByRandomId());
                    this.partRepository.saveAndFlush(part);
                }else {
                    System.out.println("Already in DB !");
                }

            }else {
                this.validationUtil.getConstraintViolations(p).stream().map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);

            }
        });
    }

    @Override
    public Part getRandomPart() {
        int randomId = this.random.nextInt((int) this.partRepository.count()) + 1;
        return this.partRepository.getById((long) randomId);
    }
}
