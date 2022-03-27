package info.log.event

import java.time.LocalDateTime

class ProductEvent(
    type: Type,
    createdAt: LocalDateTime,
    val id: Long,
    val data: ProductRequest,
): Event(type, createdAt)

data class ProductRequest(
    val name: String,
    val weight: Int,
)