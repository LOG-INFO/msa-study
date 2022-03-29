package info.log.recommendation

import info.log.api.recommendation.RecommendationResponse
import info.log.mongodb_sequence.SequenceService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class RecommendationController(
    private val sequenceService: SequenceService,
    private val recommendationService: RecommendationService,
) {

    @ApiOperation(
        value = "value",
        notes = "note"
    )
    @ApiResponses(
        value = [
            ApiResponse(code = 400, message = "Bad Request, invalid format of the request")
        ]
    )
    @GetMapping(value = ["/recommendations/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun created(@PathVariable id: Int): ResponseEntity<RecommendationResponse> {
        TODO("not implemented yet")
    }

    @ApiOperation(
        value = "value",
        notes = "note"
    )
    @ApiResponses(
        value = [
            ApiResponse(code = 400, message = "Bad Request, invalid format of the request")
        ]
    )
    @GetMapping(value = ["/recommendations/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getRecommendation(@PathVariable id: Int): ResponseEntity<RecommendationResponse> {
        TODO("not implemented yet")
    }

    @ApiOperation(
        value = "value",
        notes = "note"
    )
    @ApiResponses(
        value = [
            ApiResponse(code = 400, message = "Bad Request, invalid format of the request")
        ]
    )
    @GetMapping("/recommendations", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllRecommendationsByProductId(
        @RequestParam productId: Long,
    ): ResponseEntity<List<RecommendationResponse>> {
        TODO("not implemented yet")
    }
}