package info.log.recommendation

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "recommendations")
@CompoundIndex(name = "prod-rec-id", unique = true, def = "{'productId':1, '_id':1}")
data class Recommendation(
    @Id val id: Long,
    @Version val version: Int,
    val productId: Long,
    val author: String,
    val rate: Int,
    val content: String,
){
    companion object {
        const val SEQ_NAME = "recommendations"
    }
}