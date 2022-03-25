package info.log.product

import java.time.LocalDateTime

data class Event<K, T>(
    val type: Type,
    val key: K,
    val data: T,
    val createdAt: LocalDateTime,
) {
    enum class Type {
        CREATE, DELETE,
    }
}
