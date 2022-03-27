package info.log.product.presentation

import info.log.event.Event
import info.log.event.ProductEvent
import info.log.product.domain.Product
import info.log.product.service.ProductService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message

@Configuration
class ProductListener(
    private val productService: ProductService,
) {
    @Bean
    fun process(): (Message<ProductEvent>)->Unit{
        return {
             val payload = it.payload
            when(payload.type){
                Event.Type.CREATE -> {
                    val product = Product(
                        name=payload.data.name,
                        weight=payload.data.weight
                    )
                    productService.create(product)
                }
                Event.Type.DELETE -> {
                    productService.deleteById(payload.id)
                }
            }
        }
    }
}