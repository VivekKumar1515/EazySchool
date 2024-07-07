package org.eazybyte.com.eazybyteschool.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "courses")
public class Courses extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    @Id
    private int courseId;

    private String name;

    private String fees;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Person.class, mappedBy = "enrolledCourses")
    private Set<Person> students;
}
