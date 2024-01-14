package com.prac.msa.awsmsacartservice.awsmsacartservice.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "product-service", url = "\${msa.product-service.url}")
interface ProductServiceClient {

    @GetMapping("/api/products/{productId}/exists")
    fun isProductExists(
        @PathVariable productId: Long
    ): Boolean

    // product service 로 제품 이름 조회
    @GetMapping("/api/products/name")
    fun getProductNamesByProductIds(
        @RequestParam productIds: List<Long>
    ): List<Pair<Long, String>>
}