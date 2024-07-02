package org.eazybyte.com.eazybyteschool.Annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.eazybyte.com.eazybyteschool.Validators.FieldsMatchValidation;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FieldsMatchValidation.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsMatchValidator {
    String message() default "fields do not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field();

    String matchField();


    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        FieldsMatchValidator[] value();
    }

}
