package com.example.salesrecord

data class TransactionInfo(
    var sales: SalesInfo? = null,
    var inventory: InventoryInfo? = null,
    var quantitySold: Number? = null,
    var amountPaid: Double? = null,
    var changeLeft: Double? = null,
    var productPrice: Double? = null,
)

data class SalesInfo(val saleId: String, val saleTitle: String, val saleDate: String)


data class InventoryInfo(val productId: String, val productName: String) {
    override fun toString(): String {
        return productName
    }
}
