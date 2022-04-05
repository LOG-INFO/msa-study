package info.log.product.presentation

import info.log.api.product.ProductResponse
import info.log.event.ProductRequest
import info.log.mongodb_sequence.SequenceService
import info.log.product.domain.Product
import info.log.product.service.ProductService
import info.log.util.ServiceAddressUtil
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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
        return sequenceService.getNewId(Product.SEQ_NAME).map {
            Product(
                id = it,
                name = request.name,
                weight = request.weight
            )
        }.flatMap {
            productService.create(it)
        }.map {
            ResponseEntity.created(URI("${serviceAddressUtil.getServiceAddress()}/products/${it.id}")).body(convert(it))
        }
    }

    @DeleteMapping(value = ["/products/{id}"])
    fun deleteProduct(@PathVariable id: Long): Mono<ResponseEntity<Unit>> {
        return productService.deleteById(id)
            .map { ResponseEntity.noContent().build() }
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