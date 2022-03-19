package info.log.productcomposite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RequestMethod
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@SpringBootApplication
@EnableFeignClients(basePackages = ["info.log.api"])
class ProductCompositeApplication {
    @Bean
    fun apiDocumentation(): Docket {
        return Docket(DocumentationType.OAS_30).select()
            .apis(RequestHandlerSelectors.basePackage("info.log.productcomposite"))
            .paths(PathSelectors.any()).build().globalResponseMessage(RequestMethod.GET, emptyList()).apiInfo(
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
    runApplication<ProductCompositeApplication>(*args)
}
