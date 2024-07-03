package org.eazybyte.com.eazybyteschool.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Roles extends BaseEntity {
    @Id
    private int roleId;
    private String roleName;
}
