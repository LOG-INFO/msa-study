package info.log.productcomposite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ["info.log.api"])
class ProductCompositeApplication

fun main(args: Array<String>) {
    runApplication<ProductCompositeApplication>(*args)
}
