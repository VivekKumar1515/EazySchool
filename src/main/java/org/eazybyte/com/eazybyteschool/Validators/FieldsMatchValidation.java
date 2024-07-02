package org.eazybyte.com.eazybyteschool.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.eazybyte.com.eazybyteschool.Annotations.FieldsMatchValidator;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsMatchValidation implements ConstraintValidator<FieldsMatchValidator, Object> {

    String field;
    String matchField;


    @Override
    public void initialize(FieldsMatchValidator constraintAnnotation) {
        field = constraintAnnotation.field();
        matchField = constraintAnnotation.matchField();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object matchFieldValue = new BeanWrapperImpl(value).getPropertyValue(matchField);
        if (fieldValue != null) {
            return fieldValue.equals(matchFieldValue);
        } else {
            return matchFieldValue == null;
        }
    }
}
