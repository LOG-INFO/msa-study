package info.log.product

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service

@Service
class ProductService {
    companion object {
        const val TOPIC_PRODUCTS = "products"
    }

    @EventListener(id = TOPIC_PRODUCTS, value = [Event::class])
    fun process(event: Event<String, String>){
        when(event.type){
            Event.Type.CREATE -> {

            }
            Event.Type.DELETE -> {

            }
        }
    }

}