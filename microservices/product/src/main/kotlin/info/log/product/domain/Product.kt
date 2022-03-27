package info.log.product.domain

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "products")
data class Product(
    @Id val id: Long?=null,
    @Version val version: Int?=null,
    val name: String,
    val weight: Int,
){
    companion object {
        const val SEQ_NAME = "products"
    }
}