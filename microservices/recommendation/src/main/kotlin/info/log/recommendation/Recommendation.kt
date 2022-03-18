package info.log.recommendation

data class Recommendation(
    val id: Long,
    val productId: Long,
    val author: String,
    val rate: Int,
    val content: String,
)