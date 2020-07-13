package com.softuni.xml.dtos;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierSeedDto {

    @XmlAttribute(name = "name" )
    private String name;
    @XmlAttribute(name = "is-importer")
    private boolean isImporter;

    public SupplierSeedDto() {
    }

    @NotNull(message = "Null value")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
