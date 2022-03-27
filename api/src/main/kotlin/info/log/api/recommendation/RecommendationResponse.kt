package info.log.api.recommendation

data class RecommendationResponse(
    val id: Long,
    val productId: Long,
    val author: String,
    val rate: Int,
    val content: String,
    val serviceAddress: String?,
)