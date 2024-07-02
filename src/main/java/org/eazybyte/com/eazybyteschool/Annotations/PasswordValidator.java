package org.eazybyte.com.eazybyteschool.Annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Email;
import org.eazybyte.com.eazybyteschool.Validators.CustomPasswordValidation;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomPasswordValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {
    String message() default "the passwords do not match";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
