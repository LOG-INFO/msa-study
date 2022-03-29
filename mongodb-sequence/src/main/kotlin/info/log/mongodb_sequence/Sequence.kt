package info.log.mongodb_sequence

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collation = "sequences")
data class Sequence(
    @Id val name: String,
    val sequence: Long,
)