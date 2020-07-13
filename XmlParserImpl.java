package com.softuni.xml.utils;

import com.softuni.xml.dtos.*;

import javax.xml.bind.*;
import java.io.*;

public class XmlParserImpl implements XmlParser {

    @Override
    public <T> T unmarshalFromFile(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException {

        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (T) unmarshaller.unmarshal(new FileReader(filePath)) ;
    }
}
