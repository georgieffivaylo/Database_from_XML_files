package com.softuni.xml.config;

import com.softuni.xml.utils.*;
import org.modelmapper.*;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
public class Config {

    @Bean
    public ValidationUtil validationUtil(){
        return new ValidationUtilImpl();
    }

    @Bean
    public XmlParser xmlParser(){
        return new XmlParserImpl();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public Random random(){
        return new Random();
    }
}
