package com.softuni.xml.controller;

import com.softuni.xml.dtos.*;
import com.softuni.xml.services.*;
import com.softuni.xml.utils.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import javax.xml.bind.*;
import java.io.*;

@Component
public class AppController implements CommandLineRunner {

    private final XmlParser xmlParser;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;

    @Autowired
    public AppController(XmlParser xmlParser, SupplierService supplierService, PartService partService, CarService carService) {
        this.xmlParser = xmlParser;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
    }


    @Override
    public void run(String... args) throws Exception {
        seedTheDatabase();
    }

    private void seedTheDatabase() throws JAXBException, FileNotFoundException {
        seedSuppliers();
        seedParts();
        seedCars();
    }

    private void seedCars() throws JAXBException, FileNotFoundException {
        CarSeedRootDto carSeedRootDto =
                this.xmlParser.unmarshalFromFile("src/main/resources/cars.xml", CarSeedRootDto.class);

        this.carService.seedCars(carSeedRootDto);
    }

    private void seedParts() throws JAXBException, FileNotFoundException {

        PartSeedRootDto partSeedRootDto =
                this.xmlParser
                        .unmarshalFromFile("src/main/resources/parts.xml",
                                PartSeedRootDto.class);

        this.partService.seedParts(partSeedRootDto);
    }

    private void seedSuppliers() throws JAXBException, FileNotFoundException {

        SupplierSeedRootDto supplierSeedRootDto =
                this.xmlParser
                        .unmarshalFromFile("src/main/resources/suppliers.xml",
                                SupplierSeedRootDto.class);

        this.supplierService.seedSuppliers(supplierSeedRootDto.getSupplierSeedDtos());

    }
}
