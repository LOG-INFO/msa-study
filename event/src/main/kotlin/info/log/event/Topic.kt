package info.log.event

import java.time.LocalDateTime

enum class Topic(
    val value: String,
) {
    PRODUCTS("products"),
    RECOMMENDATIONS("recommendations"),
    REVIEWS("reviews"),
}
