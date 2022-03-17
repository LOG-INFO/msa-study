package info.log.productcomposite

import info.log.api.product.ProductClient
import info.log.api.product.ProductResponse
import info.log.api.recommendation.RecommendationClient
import info.log.api.recommendation.RecommendationResponse
import info.log.api.review.ReviewClient
import info.log.api.review.ReviewResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class ProductCompositeService(
    private val productClient: ProductClient,
    private val recommendationClient: RecommendationClient,
    private val reviewClient: ReviewClient,
) {
    fun getProduct(productId: Long): ProductResponse {
        val response = productClient.getProductById(productId)
        if (response.statusCode != HttpStatus.OK || response.body == null) {
            throw ProductNotFoundException(productId)
        }
        return response.body!!
    }

    fun getAllRecommendationsByProductId(productId: Long): List<RecommendationResponse> {
        val response = recommendationClient.getAllRecommendationsByProductId(productId)
        return response.body ?: listOf()
    }

    fun getAllReviewsByProductId(productId: Long): List<ReviewResponse> {
        val response = reviewClient.getAllReviewsByProductId(productId);
        return response.body ?: listOf()
    }
}