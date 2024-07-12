package org.eazybyte.com.eazybyteschool.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import org.hibernate.annotations.GenericGenerator;


@Data
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int contactId;
    @NotBlank(message = "this field cannot be blank")
    @Size(min = 2, max = 20, message = "name should be more than 2 characters")
    private String name;

    @NotBlank(message = "this field cannot be blank")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "this field cannot be blank")
    @Email
    private String email;

    @NotBlank(message = "this field cannot be blank")
    @Size(min = 5, max = 50, message = "subject should be more than 5 characters long")
    private String subject;

    @NotBlank(message = "this field cannot be blank")
    @Size(min = 2, max = 200, message = "message should be within 2-200 characters long")
    private String message;

    private String status;
}
