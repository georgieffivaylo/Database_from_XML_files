package com.softuni.xml.utils;

import javax.validation.*;
import java.util.*;

public interface ValidationUtil {

    <T> boolean isValid(T entity);

    <T> Set<ConstraintViolation<T>> getConstraintViolations(T entity);
}
