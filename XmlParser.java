package com.softuni.xml.utils;

import javax.xml.bind.*;
import java.io.*;

public interface XmlParser {

    <T> T unmarshalFromFile(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException;

}
