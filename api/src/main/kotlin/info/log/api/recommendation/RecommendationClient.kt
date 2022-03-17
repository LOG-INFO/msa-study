package info.log.api.recommendation

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "audio-api-client",
    url = "\${feign.url.recommendation}",
)
interface RecommendationClient {
    @GetMapping("/recommendations")
    fun getAllRecommendationsByProductId(
        @RequestParam productId: Long,
    ): ResponseEntity<List<RecommendationResponse>>
}