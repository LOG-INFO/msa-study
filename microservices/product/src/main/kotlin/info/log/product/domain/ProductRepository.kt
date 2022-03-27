package info.log.product.domain

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ProductRepository: ReactiveMongoRepository<Product, Long> {
}