package info.log.review

import org.springframework.data.repository.CrudRepository

interface ReviewRepository : CrudRepository<Review, Long> {
    fun findByProductId(productId: Int): List<Review>
}