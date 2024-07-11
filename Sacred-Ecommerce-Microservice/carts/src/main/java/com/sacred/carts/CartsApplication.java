package com.sacred.carts;

import com.sacred.carts.dto.ConfigurationDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "cartAuditAware")
@EnableConfigurationProperties(ConfigurationDto.class)
@OpenAPIDefinition(
		info = @Info(
				title = "Cart Microservice Rest Documentation",
				description = "Documentation of Sacred-Ecommerce-Microservices Cart Microservice REST API",
				version = "v1",
				license = @License(
						url = "will replace with linkedin"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Sacred-Ecommerce Cart microservice REST API Documentation"
		)
)
public class CartsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartsApplication.class, args);
	}

}
