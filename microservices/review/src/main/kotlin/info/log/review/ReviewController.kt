package info.log.review

import info.log.api.review.ReviewResponse
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ReviewController(
    private val reviewService: ReviewService,
) {
    @GetMapping(value = ["/review/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getReview(@PathVariable id: Int): ResponseEntity<ReviewResponse> {
        TODO("not implemented yet")
    }

    @GetMapping("/reviews")
    fun getAllReviewsByProductId(
        @RequestParam productId: Long,
    ): ResponseEntity<List<ReviewResponse>>{
        TODO("not implemented yet")
    }
}