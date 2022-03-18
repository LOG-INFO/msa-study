package info.log.review

import javax.persistence.*

@Entity
@Table(name = "reviews", indexes = [Index(name = "reviews_unique_index", unique = true, columnList = "productId,id")])
data class Review(
    @Id @GeneratedValue val id: Long,
    @Version val version: Int,
    val productId: Long,
    val author: String,
    val subject: String,
    val content: String,
)