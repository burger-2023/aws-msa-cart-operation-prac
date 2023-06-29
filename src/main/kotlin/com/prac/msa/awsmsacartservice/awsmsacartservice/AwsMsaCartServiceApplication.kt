package com.prac.msa.awsmsacartservice.awsmsacartservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class AwsMsaCartServiceApplication

fun main(args: Array<String>) {
    runApplication<AwsMsaCartServiceApplication>(*args)
}
