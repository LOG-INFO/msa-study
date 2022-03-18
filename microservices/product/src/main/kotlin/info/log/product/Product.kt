package info.log.product

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "products")
data class Product(
    @Id val id: Long,
    @Version val version: Int,
    val name: String,
    val weight: Int,
    val serviceAddress: String,
)