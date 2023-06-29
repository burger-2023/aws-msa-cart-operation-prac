package com.prac.msa.awsmsacartservice.awsmsacartservice.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "product-service", url = "\${msa.product-service.url}")
interface ProductServiceClient {

    @GetMapping("/products/{productId}/exists")
    fun isProductExists(
        @PathVariable productId: Long
    ): Boolean
}