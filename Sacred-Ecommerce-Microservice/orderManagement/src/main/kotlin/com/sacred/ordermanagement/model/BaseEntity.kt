package com.sacred.ordermanagement.model

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import lombok.AllArgsConstructor
import lombok.Data
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity(
        @CreatedBy
        @Column(updatable = false)
        val createdBy: String? = null,

        @CreatedDate
        @Column(updatable = false)
        val createAt: LocalDateTime? = null,

        @LastModifiedBy
        @Column(insertable = false)
        val updatedBy: String? = null,

        @Column(insertable = false)
        @LastModifiedDate
        val updatedAt: LocalDateTime? = null
)
