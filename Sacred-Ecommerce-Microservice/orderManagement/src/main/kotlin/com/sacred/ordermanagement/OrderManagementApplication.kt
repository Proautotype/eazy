package com.sacred.ordermanagement

import com.sacred.ordermanagement.dto.ConfigurationDto
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing


@OpenAPIDefinition(
		info = Info(
				title = "Order Management Rest",
				description = "REST Api for Order Management, in Sacred Ecommerce Microservice",
				version = "v1"
		)
)
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(ConfigurationDto::class)
class OrderManagementApplication

fun main(args: Array<String>) {
	runApplication<OrderManagementApplication>(*args)
}
