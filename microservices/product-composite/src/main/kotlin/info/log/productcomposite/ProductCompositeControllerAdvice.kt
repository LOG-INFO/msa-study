package info.log.productcomposite

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ProductCompositeControllerAdvice {
    @ExceptionHandler(ProductNotFoundException::class)
    fun productNotFoundException(ex: ProductNotFoundException): ResponseEntity<Unit>{
        //TODO: log로 대체
        println("${ex.message}: ${ex.stackTrace}")
        return ResponseEntity.notFound().build()
    }
}