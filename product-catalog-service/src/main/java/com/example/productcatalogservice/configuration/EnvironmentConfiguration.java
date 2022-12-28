package com.example.productcatalogservice.configuration;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
@ConfigurationProperties("product-catalog-service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnvironmentConfiguration {
    private String env;
}
