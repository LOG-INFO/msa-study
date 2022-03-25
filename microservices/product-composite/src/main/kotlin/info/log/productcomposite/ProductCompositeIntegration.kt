package info.log.productcomposite

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ProductCompositeIntegration(
    val kafkaTemplate: KafkaTemplate<String, Event<String,String>>,
) {

    fun outputProducts(event: Event<String, String>) {
        output(Topic.PRODUCTS, event)
    }

    fun outputRecommendations(event: Event<String, String>) {
        output(Topic.RECOMMENDATIONS, event)
    }

    fun outputReviews(event: Event<String, String>) {
        output(Topic.REVIEWS, event)
    }

    private fun output(topic: String, event: Event<String, String>) {
        kafkaTemplate.send(Topic.REVIEWS, event)
    }
}