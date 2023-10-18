package com.prac.msa.awsmsacartservice.awsmsacartservice.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "user-service", url = "\${msa.user-service.url}")
interface UserServiceClient {

    @GetMapping("/api/users/{userId}/exists")
    fun isUserExists(
        @PathVariable userId: Long
    ): Boolean
}