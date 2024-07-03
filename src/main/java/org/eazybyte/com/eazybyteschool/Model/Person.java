package org.eazybyte.com.eazybyteschool.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.eazybyte.com.eazybyteschool.Annotations.FieldsMatchValidator;
import org.eazybyte.com.eazybyteschool.Annotations.PasswordValidator;
import org.hibernate.annotations.GenericGenerator;

import javax.management.relation.Role;

@Data
@Entity
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
public class Person extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Id
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
    @Transient
    private String confirmEmail;

    @NotBlank(message = "field cannot be empty")
    @PasswordValidator()
    private String pwd;

    @NotBlank(message = "field cannot be empty")
    @Transient
    private String confirmPwd;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, targetEntity = Roles.class)
    @JoinColumn(name = "role_id", referencedColumnName = "roleId", nullable = false)
    private Roles role;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Address.class)
    @JoinColumn(name = "address_id", referencedColumnName = "addressId", nullable = false)
    private Address address;
}