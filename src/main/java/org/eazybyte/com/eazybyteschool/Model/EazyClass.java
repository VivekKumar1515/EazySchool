package org.eazybyte.com.eazybyteschool.Model;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Setter
@Getter
@Entity()
@Table(name = "class")
public class EazyClass extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int classId;

    @NotBlank(message = "name of the class cannot be empty")
    @Size(min = 3, message = "name of the class should be more than length 3")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eazyclass", cascade = CascadeType.PERSIST)
    private Set<Person> person;
}
