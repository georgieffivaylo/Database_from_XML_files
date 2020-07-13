package com.softuni.xml.services;

import com.softuni.xml.dtos.*;
import com.softuni.xml.entities.*;

import java.util.*;

public interface SupplierService {

    void seedSuppliers(List<SupplierSeedDto> supplierSeedDtos);

    Supplier getByRandomId();
}
