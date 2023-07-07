package com.prac.msa.awsmsacartservice.awsmsacartservice

import com.prac.msa.awsmsacartservice.awsmsacartservice.entity.CartItem
import com.prac.msa.awsmsacartservice.awsmsacartservice.repository.CartRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val cartRepository: CartRepository
) : CommandLineRunner {

    override fun run(vararg args: String) {
        val count = cartRepository.count()
        if (count == 0L) {
            val item1 = CartItem(
                productId = 1,
                userId = 1,
                quantity = 1
            )
            val item2 = CartItem(
                productId = 2,
                userId = 1,
                quantity = 1
            )
            val item3 = CartItem(
                productId = 1,
                userId = 2,
                quantity = 3
            )
            val item4 = CartItem(
                productId = 2,
                userId = 2,
                quantity = 2
            )
            cartRepository.save(item1)
            cartRepository.save(item2)
            cartRepository.save(item3)
            cartRepository.save(item4)
        }
    }
}