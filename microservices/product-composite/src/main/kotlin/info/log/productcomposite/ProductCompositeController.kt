package info.log.productcomposite

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductCompositeController(
    private val productCompositeService: ProductCompositeService,
) {
    @GetMapping("/productcomposite/{id}")
    fun getProductAggregate(
        @PathVariable id: Long,
    ): ResponseEntity<ProductAggregate>{
        val product = productCompositeService.getProduct(id)
        val recommendations = productCompositeService.getAllRecommendationsByProductId(id)
        val reviews = productCompositeService.getAllReviewsByProductId(id)
        val aggregate = ProductAggregate(
            id = id,
            name = product.name,
            weight = product.weight,
            serviceAddress = product.serviceAddress,
            recommendations = recommendations,
            reviews = reviews,
        )

        return ResponseEntity.ok(aggregate)
    }
}