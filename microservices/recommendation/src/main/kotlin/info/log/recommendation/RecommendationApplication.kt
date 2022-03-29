package info.log.recommendation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import org.springframework.web.bind.annotation.RequestMethod
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors.basePackage
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@SpringBootApplication(scanBasePackages = ["info.log.recommendation", "info.log.util"])
@ComponentScan("info.log.util", "info.log.recommendation", "info.log.mongodb_sequence")
@EnableFeignClients(basePackages = ["info.log.api"])
@EnableReactiveMongoRepositories
class RecommendationApplication {
    @Bean
    fun apiDocumentation(): Docket {
        return Docket(DocumentationType.OAS_30)
            .select()
            .apis(basePackage("info.log.recommendation"))
            .paths(PathSelectors.any())
            .build()
            .globalResponseMessage(RequestMethod.GET, emptyList())
            .apiInfo(
                ApiInfo(
                    "apiTitle",
                    "apiDescription",
                    "apiVersion",
                    "apiTermsOfServiceUrl",
                    Contact("contactName", "contactUrl", "contactEmail"),
                    "apiLicense",
                    "apiLicenseUrl",
                    emptyList()
                )
            )
    }
}

fun main(args: Array<String>) {
    runApplication<RecommendationApplication>(*args)
}
