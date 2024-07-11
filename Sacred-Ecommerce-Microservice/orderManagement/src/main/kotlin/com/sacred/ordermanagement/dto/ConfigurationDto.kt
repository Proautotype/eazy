package com.sacred.ordermanagement.dto

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "products")
 data class ConfigurationDto(
  var profile: String = "",
  var message: String = "",
  var service: String = ""
 )