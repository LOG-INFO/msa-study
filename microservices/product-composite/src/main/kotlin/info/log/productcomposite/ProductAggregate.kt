package info.log.productcomposite

import info.log.api.recommendation.RecommendationResponse
import info.log.api.review.ReviewResponse

data class ProductAggregate(
    val id: Long,
    val name: String,
    val weight: Int,
    val recommendations: List<RecommendationResponse>,
    val reviews: List<ReviewResponse>,
    val serviceAddress: String,
)