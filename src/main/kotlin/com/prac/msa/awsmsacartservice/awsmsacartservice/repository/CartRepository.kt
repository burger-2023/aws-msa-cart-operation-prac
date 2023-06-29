package com.prac.msa.awsmsacartservice.awsmsacartservice.repository

import com.prac.msa.awsmsacartservice.awsmsacartservice.entity.CartItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CartRepository : JpaRepository<CartItem, Long> {

    fun findByUserId(userId: Long): List<CartItem>
}
