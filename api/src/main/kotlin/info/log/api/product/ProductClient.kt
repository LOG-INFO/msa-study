package info.log.api.product

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "audio-api-client",
    url = "\${feign.url.product}",
)
interface ProductClient {
    fun getProductById(@PathVariable id: Long): ResponseEntity<ProductResponse>
}