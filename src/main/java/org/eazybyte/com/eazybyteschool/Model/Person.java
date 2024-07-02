package org.eazybyte.com.eazybyteschool.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.eazybyte.com.eazybyteschool.Annotations.FieldsMatchValidator;
import org.eazybyte.com.eazybyteschool.Annotations.PasswordValidator;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "person")
@FieldsMatchValidator.List({
        @FieldsMatchValidator(
                field = "email",
                matchField = "confirmEmail",
                message = "email does not match"
        ),
        @FieldsMatchValidator(
                field = "pwd",
                matchField = "confirmPwd",
                message = "passwords do not match"
        )
})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int personId;

    @NotBlank(message = "field cannot be empty")
    @Size(max = 20, min = 2, message = "name should be more than 2 characters")
    private String name;

    @NotBlank(message = "field cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "enter a valid phone number")
    private String mobileNumber;

    @NotBlank(message = "field cannot be empty")
    @Email
    private String email;

    @NotBlank(message = "field cannot be empty")
    @Email
    private String confirmEmail;

    @PasswordValidator()
    private String pwd;
    private String confirmPwd;
}
