package com.softuni.xml.dtos;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierSeedRootDto {

    @XmlElement(name = "supplier")
    private List<SupplierSeedDto> supplierSeedDtos;

    public SupplierSeedRootDto() {
    }

    public List<SupplierSeedDto> getSupplierSeedDtos() {
        return supplierSeedDtos;
    }

    public void setSupplierSeedDtos(List<SupplierSeedDto> supplierSeedDtos) {
        this.supplierSeedDtos = supplierSeedDtos;
    }
}
