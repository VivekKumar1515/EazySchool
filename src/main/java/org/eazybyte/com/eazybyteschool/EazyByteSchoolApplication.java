package org.eazybyte.com.eazybyteschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(value = "org.eazybyte.com.eazybyteschool.Model")
@EnableJpaRepositories("org.eazybyte.com.eazybyteschool.Repository")
public class EazyByteSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(EazyByteSchoolApplication.class, args);
    }

}
