package com.softuni.xml.dtos;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarSeedRootDto {

    @XmlElement(name = "car")
    private List<CarSeedDto> carSeedDtos;

    public CarSeedRootDto() {
    }

    public List<CarSeedDto> getCarSeedDtos() {
        return carSeedDtos;
    }

    public void setCarSeedDtos(List<CarSeedDto> carSeedDtos) {
        this.carSeedDtos = carSeedDtos;
    }
}
