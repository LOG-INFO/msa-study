package info.log.event

import java.time.LocalDateTime

abstract class Event(
    val type: Type,
    val createdAt: LocalDateTime,
) {
    enum class Type {
        CREATE, DELETE,
    }
}
