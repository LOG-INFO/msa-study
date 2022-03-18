package info.log.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ["info.log.api"])
class ProductApplication

fun main(args: Array<String>) {
    runApplication<ProductApplication>(*args)
}
