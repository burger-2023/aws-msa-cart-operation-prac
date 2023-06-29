package com.prac.msa.awsmsacartservice.awsmsacartservice.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "cart_items")
data class CartItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @JsonIgnore
    @Column(name = "product_id", nullable = false)
    val productId: Long,

    @JsonIgnore
    @Column(name = "user_id", nullable = false)
    val userId: Long,

    @Column(nullable = false)
    val quantity: Int
)