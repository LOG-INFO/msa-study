package info.log.review

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ["info.log.api"])
class ReviewApplication

fun main(args: Array<String>) {
    runApplication<ReviewApplication>(*args)
}
