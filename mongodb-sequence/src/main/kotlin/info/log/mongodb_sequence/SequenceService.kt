package info.log.mongodb_sequence

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class SequenceService(
    private val sequenceRepository: SequenceRepository,
) {

    fun getNewId(sequenceName: String): Mono<Long> {
        return sequenceRepository.findById(sequenceName)
            .switchIfEmpty(Mono.just(Sequence(sequenceName, 0L)))
            .flatMap {
                it.sequence = it.sequence + 1
                sequenceRepository.save(it)
            }
            .map { it.sequence }
    }
}