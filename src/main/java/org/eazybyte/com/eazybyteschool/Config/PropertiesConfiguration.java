package org.eazybyte.com.eazybyteschool.Config;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Configuration
@Data
@ConfigurationProperties(prefix = "eazyschool")
@Validated
    //This class is created to showcase the usecase of the @ConfigurationProperties annotations
public class PropertiesConfiguration {
    @Min(value = 5, message = "the size of the page should be between 5 to 25")
    @Max(value = 25, message = "the size of the page should be between 5 to 25")
    private int pageSize;

    private Map<String, String> contact;

    private List<String> branch;
}
