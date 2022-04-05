package info.log.product.service

import info.log.product.domain.Product
import info.log.product.domain.ProductRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {

    fun create(product: Product): Mono<Product> {
        return productRepository.save(product)
            .log()
    }

    fun findById(id: Long): Mono<Product> {
        return productRepository.findById(id)
    }

    fun findAll(): Flux<Product> {
        return productRepository.findAll()
    }

    fun deleteById(id: Long): Mono<Unit> {
        return productRepository.deleteById(id)
            .map { }
            .log()
    }

}