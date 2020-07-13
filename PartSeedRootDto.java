package com.softuni.xml.dtos;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "parts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartSeedRootDto {

    @XmlElement(name = "part")
    List<PartSeedDto> partSeedDtos;

    public PartSeedRootDto() {
    }

    public List<PartSeedDto> getPartSeedDtos() {
        return partSeedDtos;
    }

    public void setPartSeedDtos(List<PartSeedDto> partSeedDtos) {
        this.partSeedDtos = partSeedDtos;
    }
}
