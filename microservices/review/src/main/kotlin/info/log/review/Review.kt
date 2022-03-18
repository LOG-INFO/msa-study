package info.log.review

data class Review(
    val id: Long,
    val productId: Long,
    val author: String,
    val subject: String,
    val content: String,
)