package info.log.mongodb_sequence

import org.springframework.stereotype.Service

@Service
class SequenceService (
    private val sequenceRepository: SequenceRepository,
        ){

    fun getNewId(sequenceName: String): Long{
        val sequence = sequenceRepository.findById(sequenceName).block()

        if(sequence==null){
            val newId = 1L
            sequenceRepository.save(Sequence(sequenceName, newId)).block()
            return newId
        }

        return sequence.sequence
    }
}