package com.softuni.xml.services.impls;

import com.softuni.xml.dtos.*;
import com.softuni.xml.entities.*;
import com.softuni.xml.repositories.*;
import com.softuni.xml.services.*;
import com.softuni.xml.utils.*;
import org.modelmapper.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final PartService partService;
    private final Random random;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, ValidationUtil validationUtil, PartService partService, Random random) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.partService = partService;
        this.random = random;
    }

    @Override
    public void seedCars(CarSeedRootDto carSeedRootDto) {

        if (this.carRepository.count() != 0) {
            return;
        }

        carSeedRootDto.getCarSeedDtos().stream().forEach(c -> {
            if (this.validationUtil.isValid(c)) {
                if (this.carRepository.findByMakeAndModel(c.getMake(), c.getModel()) == null) {

                    Car car = this.modelMapper.map(c, Car.class);
                    int randomBound = this.random.nextInt(11) + 10;
                    for (int i = 0; i < randomBound; i++) {
                        try {
                            car.getParts().add(this.partService.getRandomPart());
                        }catch (NullPointerException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    this.carRepository.saveAndFlush(car);
                } else {
                    System.out.println("Already in DB !");
                }
            }else {
                this.validationUtil.getConstraintViolations(c).forEach(car -> {
                    System.out.println(car.getMessage());
                });
            }
        });
    }
}
