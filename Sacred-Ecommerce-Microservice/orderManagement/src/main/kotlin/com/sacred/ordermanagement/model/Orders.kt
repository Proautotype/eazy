package com.sacred.ordermanagement.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Data
import java.time.LocalDateTime

@Entity
data class Orders (
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   val id: Long,
   var userId: Long
): BaseEntity()
