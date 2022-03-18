package info.log.recommendation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RequestMethod
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors.basePackage
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux

@SpringBootApplication
@EnableSwagger2WebFlux
@EnableFeignClients(basePackages = ["info.log.api"])
class RecommendationApplication {
    @Bean
    fun apiDocumentation(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
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
                    Contact("contactName", "contackUrl", "contactEmail"),
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
