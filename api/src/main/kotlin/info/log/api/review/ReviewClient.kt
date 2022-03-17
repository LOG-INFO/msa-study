package info.log.api.review

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "audio-api-client",
    url = "\${feign.url.review}",
)
interface ReviewClient {
    @GetMapping("/reviews")
    fun getAllReviewsByProductId(
        @RequestParam productId: Long,
    ): ResponseEntity<List<ReviewResponse>>
}