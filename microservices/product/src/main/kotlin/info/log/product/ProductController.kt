package info.log.product

import info.log.api.product.ProductResponse
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController {
    @GetMapping(value = ["/products/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getProduct(@PathVariable id: Int): ResponseEntity<ProductResponse> {
        TODO("not implemented yet")
    }
}