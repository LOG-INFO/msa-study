package info.log.mongodb_sequence

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "sequences")
data class Sequence(
    @Id val name: String,
    var sequence: Long,
)