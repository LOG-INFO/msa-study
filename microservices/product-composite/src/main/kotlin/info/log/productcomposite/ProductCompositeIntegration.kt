package info.log.productcomposite

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ProductCompositeIntegration(
    val kafkaTemplate: KafkaTemplate<String, Event<String,String>>,
) {
    companion object {
        const val TOPIC_PRODUCTS = "products"
        const val TOPIC_RECOMMENDATIONS = "recommendations"
        const val TOPIC_REVIEWS = "reviews"
    }

    fun outputProducts(event: Event<String, String>) {
        output(TOPIC_PRODUCTS, event)
    }

    fun outputRecommendations(event: Event<String, String>) {
        output(TOPIC_RECOMMENDATIONS, event)
    }

    fun outputReviews(event: Event<String, String>) {
        output(TOPIC_REVIEWS, event)
    }

    private fun output(topic: String, event: Event<String, String>) {
        kafkaTemplate.send(TOPIC_REVIEWS, event)
    }
}