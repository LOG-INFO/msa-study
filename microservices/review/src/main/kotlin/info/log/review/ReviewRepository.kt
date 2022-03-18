package info.log.review

import org.springframework.data.repository.CrudRepository
import javax.transaction.Transactional

interface ReviewRepository : CrudRepository<Review, Long> {
    @Transactional
    fun findByProductId(productId: Int): List<Review>
}