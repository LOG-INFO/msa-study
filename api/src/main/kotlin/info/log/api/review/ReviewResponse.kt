package info.log.api.review

data class ReviewResponse(
    val id: Long,
    val productId: Long,
    val author: String,
    val subject: String,
    val content: String,
)
