package com.prac.msa.awsmsacartservice.awsmsacartservice.service

import com.prac.msa.awsmsacartservice.awsmsacartservice.client.ProductServiceClient
import com.prac.msa.awsmsacartservice.awsmsacartservice.client.UserServiceClient
import com.prac.msa.awsmsacartservice.awsmsacartservice.entity.CartItem
import com.prac.msa.awsmsacartservice.awsmsacartservice.error.ProductNotFoundException
import com.prac.msa.awsmsacartservice.awsmsacartservice.error.UserNotFoundException
import com.prac.msa.awsmsacartservice.awsmsacartservice.repository.CartRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CartService(
    private val cartRepository: CartRepository,
    private val productServiceClient: ProductServiceClient,
    private val userServiceClient: UserServiceClient
) {

    @Transactional
    fun addToCart(productId: Long, quantity: Int, userId: Long): CartItem {
        productServiceClient.isProductExists(productId).let {
            if (!it) throw ProductNotFoundException("존재하지 않는 제품입니다.")
        }
        userServiceClient.isUserExists(userId).let {
            if (!it) throw UserNotFoundException("존재하지 않는 유저입니다.")
        }
        val cartItem = CartItem(productId = productId, quantity = quantity, userId = userId)
        cartItem.productName = productServiceClient.getProductNamesByProductIds(listOf(productId)).first().second

        return cartRepository.save(cartItem)
    }

    @Transactional(readOnly = true)
    fun findAllProducts(userId: Long): List<CartItem> {
        val carts = cartRepository.findByUserId(userId)
        val productIds = carts.map { it.productId }
        productServiceClient.getProductNamesByProductIds(productIds).run {
            carts.forEach { cartItem ->
                cartItem.productName = this.first { cartItem.productId == it.first }.second
            }
        }
        return carts
    }
}
