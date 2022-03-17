package info.log.recommendation

import info.log.api.recommendation.RecommendationResponse
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RecommendationController(
    private val recommendationService: RecommendationService,
) {
    @GetMapping(value = ["/recommendations/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getRecommendation(@PathVariable id: Int): ResponseEntity<RecommendationResponse> {
        TODO("not implemented yet")
    }

    @GetMapping("/recommendations")
    fun getAllRecommendationsByProductId(
        @RequestParam productId: Long,
    ): ResponseEntity<List<RecommendationResponse>>{
        TODO("not implemented yet")
    }
}