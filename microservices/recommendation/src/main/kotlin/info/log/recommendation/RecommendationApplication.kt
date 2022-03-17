package info.log.recommendation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ["info.log.api"])
class RecommendationApplication

fun main(args: Array<String>) {
    runApplication<RecommendationApplication>(*args)
}
