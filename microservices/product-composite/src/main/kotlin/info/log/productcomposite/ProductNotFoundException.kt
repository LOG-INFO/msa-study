package info.log.productcomposite

class ProductNotFoundException(productId: Long) : IllegalArgumentException("not found product: $productId") {
}