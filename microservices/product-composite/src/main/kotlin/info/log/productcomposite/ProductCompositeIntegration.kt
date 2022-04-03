package info.log.productcomposite

import info.log.event.Event
import info.log.event.Topic
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ProductCompositeIntegration(
    val kafkaTemplate: KafkaTemplate<String, Event>,
) {

    fun outputProducts(event: Event) {
        output(Topic.PRODUCTS, event)
    }

    fun outputRecommendations(event: Event) {
        output(Topic.RECOMMENDATIONS, event)
    }

    fun outputReviews(event: Event) {
        output(Topic.REVIEWS, event)
    }

    private fun output(topic: Topic, event: Event) {
        kafkaTemplate.send(Topic.REVIEWS.value, event)
    }
}