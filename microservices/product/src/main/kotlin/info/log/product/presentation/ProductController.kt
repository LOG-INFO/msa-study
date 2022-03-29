package info.log.product.presentation

import info.log.api.product.ProductResponse
import info.log.event.ProductRequest
import info.log.mongodb_sequence.SequenceRepository
import info.log.mongodb_sequence.SequenceService
import info.log.util.ServiceAddressUtil
import info.log.product.domain.Product
import info.log.product.service.ProductService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.net.URI

@RestController
class ProductController(
    private val productService: ProductService,
    private val sequenceService: SequenceService,
    private val serviceAddressUtil: ServiceAddressUtil,
) {
    @GetMapping(value = ["/products/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getProduct(@PathVariable id: Long): Mono<ResponseEntity<ProductResponse>> {
        val productMono = productService.findById(id)
        return productMono.log()
            .map { ResponseEntity.ok(convert(it)) }
    }

    @GetMapping(value = ["/products"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllProducts(): Flux<ResponseEntity<ProductResponse>> {
        val productsFlux = productService.findAll()
        return productsFlux.log()
            .map { ResponseEntity.ok(convert(it)) }
    }

    @PostMapping(value = ["/products"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createProduct(@RequestBody request: ProductRequest): Mono<ResponseEntity<ProductResponse>> {
        val product = Product(
            id = sequenceService.getNewId(Product.SEQ_NAME),
            name = request.name,
            weight = request.weight
        )
        return productService.create(product).map {
            ResponseEntity.created(URI("${serviceAddressUtil.getServiceAddress()}/products/${it.id}")).body(convert(it))
        }
    }

    private fun convert(product: Product): ProductResponse {
        return product.let {
            ProductResponse(
                id = it.id!!,
                name = it.name,
                weight = it.weight,
                serviceAddress = serviceAddressUtil.getServiceAddress()
            )
        }
    }
}