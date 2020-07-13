package com.softuni.xml.services;

import com.softuni.xml.dtos.*;
import com.softuni.xml.entities.*;

public interface PartService {

    void seedParts(PartSeedRootDto partSeedRootDto);

    Part getRandomPart();
}
