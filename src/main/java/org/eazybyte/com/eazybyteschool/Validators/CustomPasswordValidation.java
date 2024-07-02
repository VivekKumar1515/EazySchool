package org.eazybyte.com.eazybyteschool.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.eazybyte.com.eazybyteschool.Annotations.PasswordValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomPasswordValidation implements ConstraintValidator<PasswordValidator, String> {
    List<String> weakPasswords;

    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        weakPasswords = Arrays.asList("qwerty", "asdfghjkl", "zxcvbn", "0123456789", "12345");
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return password != null && (!weakPasswords.contains(password));
    }
}
