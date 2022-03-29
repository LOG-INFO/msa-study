package info.log.recommendation

import info.log.mongodb_sequence.SequenceRepository
import org.springframework.stereotype.Service

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class RecommendationService(
    private val recommendationRepository: RecommendationRepository,
) {

    fun create(product: Recommendation): Mono<Recommendation>{
        return recommendationRepository.save(product)
            .log()
    }

    fun findById(id: Long): Mono<Recommendation> {
        return recommendationRepository.findById(id)
    }

    fun findAll(): Flux<Recommendation> {
        return recommendationRepository.findAll()
    }

    fun deleteById(id: Long){
        recommendationRepository.deleteById(id)
            .log()
    }

}