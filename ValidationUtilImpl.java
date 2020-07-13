package com.softuni.xml.utils;

import javax.validation.*;
import java.util.*;

public class ValidationUtilImpl implements ValidationUtil {

    private final Validator validator;

    public ValidationUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Override
    public <T> boolean isValid(T entity) {
        return this.validator.validate(entity).isEmpty();
    }

    @Override
    public <T> Set<ConstraintViolation<T>> getConstraintViolations(T entity) {
        return this.validator.validate(entity);
    }
}
