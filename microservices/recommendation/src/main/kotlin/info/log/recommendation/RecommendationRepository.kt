package info.log.recommendation

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RecommendationRepository: ReactiveMongoRepository<Recommendation, Long> {

}
