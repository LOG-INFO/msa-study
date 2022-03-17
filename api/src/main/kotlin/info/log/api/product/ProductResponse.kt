package info.log.api.product

data class ProductResponse(
    val id: Long,
    val name: String,
    val weight: Int,
    val serviceAddress: String,
)