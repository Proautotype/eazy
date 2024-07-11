package com.sacred.products;

import com.sacred.products.audit.AuditAwareImpl;
import com.sacred.products.dto.ConfigurationDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Products Microservice Rest Documentation",
                description = "Documentation of Sacred-Ecommerce-Microservices Products Microservice REST API",
                version = "v1",
                license = @License(
                        url = "will replace with linkedin"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Sacred-Ecommerce Products microservice REST API Documentation"
        )
)
@EnableConfigurationProperties(ConfigurationDto.class)
public class ProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class, args);
    }

}
