package info.log.product.domain

import nonapi.io.github.classgraph.json.Id

data class Sequence(
    @Id val name: String,
    val sequence: Long,
)