package info.log.mongodb_sequence

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface SequenceRepository: ReactiveMongoRepository<Sequence, String> {
}