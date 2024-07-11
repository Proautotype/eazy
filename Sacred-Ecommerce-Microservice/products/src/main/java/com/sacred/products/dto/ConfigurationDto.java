package com.sacred.products.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "products")
@Setter @Getter
public class ConfigurationDto {
    String message;
    String profile;
    String service;
}
