package com.prac.msa.awsmsacartservice.awsmsacartservice.controller

import com.prac.msa.awsmsacartservice.awsmsacartservice.entity.CartItem
import com.prac.msa.awsmsacartservice.awsmsacartservice.service.CartService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/api/carts")
class CartController(
    private val cartService: CartService
) {

    /**
     * POST -  제품을 장바구니에 추가합니다.
     * */
    @PostMapping("/register")
    fun addToCart(
        @RequestParam productId: Long,
        @RequestParam quantity: Int,
        @RequestParam userId: Long
    ): ResponseEntity<CartItem> {
        val updatedCart = cartService.addToCart(productId, quantity, userId)

        return ResponseEntity.ok(updatedCart)
    }

    /**
     * GET -  모든 장바구니 항목을 검색합니다.
     * */
    @GetMapping
    fun getAllCarts(
        @RequestParam("userId") userId: Long? ,
        @RequestHeader("userId") headerUserId: Long?,
    ): ResponseEntity<List<CartItem>> {
        val cartItems = cartService.getAllCarts(userId ?: headerUserId ?: throw Exception("유저 id가 없습니다."))

        return ResponseEntity.ok(cartItems)
    }
}