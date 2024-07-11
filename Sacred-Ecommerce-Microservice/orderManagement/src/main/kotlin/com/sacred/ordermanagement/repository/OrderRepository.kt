package com.sacred.ordermanagement.repository

import com.sacred.ordermanagement.model.Orders
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: JpaRepository<Orders, Long>