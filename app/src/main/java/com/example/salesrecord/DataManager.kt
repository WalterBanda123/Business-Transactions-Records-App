package com.example.salesrecord

object DataManager {

    val sales = HashMap<String, SalesInfo>()
    val stocks = HashMap<String, InventoryInfo>()
    val transactions = ArrayList<TransactionInfo>()

    init {

        initializeSales()
        initializeInventory()
        initializeTransactions()
    }

    private fun initializeSales() {
        var sale = SalesInfo(
            saleId = "sale_1",
            saleTitle = "Sales for Tuesday",
            saleDate = Long.toString()
        )
        sales.set(sale.saleId, sale)

        sale = SalesInfo(
            saleId = "sale_2",
            saleTitle = "Sales for Wednesday",
            saleDate = Long.toString()
        )
        sales.set(sale.saleId, sale)

        sale = SalesInfo(
            saleId = "sale_3",
            saleTitle = "Sales for Thursday",
            saleDate = Long.toString()
        )
        sales[sale.saleId] = sale

        sale =
            SalesInfo(saleId = "sale_4", saleTitle = "Sales for Friday", saleDate = Long.toString())
        sales[sale.saleId] = sale
    }

    private fun initializeInventory() {
        var productInStock =
            InventoryInfo(productId = "product_1", productName = "Mazoe Orange Crush")
        stocks[productInStock.productId] = productInStock

        productInStock = InventoryInfo(productId = "product_2", productName = "Mazoe Blackberry")
        stocks[productInStock.productId] = productInStock

        productInStock = InventoryInfo(productId = "product_3", productName = "Mirinda Orange")
        stocks[productInStock.productId] = productInStock

        productInStock = InventoryInfo(productId = "product_4", productName = "Mirinda Grape")
        stocks[productInStock.productId] = productInStock
    }

    private fun initializeTransactions() {
        var sale = sales["sale_1"]!!
        var stock = stocks["product_1"]!!
        var trans =
            TransactionInfo(
                sale,
                stock,
                quantitySold = 6,
                amountPaid = 16.5,
                changeLeft = 3.20,
                productPrice = 8.40
            )
        transactions.add(trans)

        sale = sales["sale_2"]!!
        stock = stocks["product_2"]!!
        trans =
            TransactionInfo(
                sale,
                stock,
                quantitySold = 10,
                amountPaid = 23.50,
                changeLeft = 6.40,
                productPrice = 7.20
            )
        transactions.add(trans)

        sale = sales["sale_3"]!!
        stock = stocks["product_3"]!!
        trans =
            TransactionInfo(
                sale,
                stock,
                quantitySold = 50,
                amountPaid = 63.50,
                changeLeft = 8.90,
                productPrice = 56.54
            )
        transactions.add(trans)
        sale = sales["sale_3"]!!
        stock = stocks["product_3"]!!
        trans =
            TransactionInfo(
                sale,
                stock,
                quantitySold = 50,
                amountPaid = 63.50,
                changeLeft = 8.90,
                productPrice = 56.54
            )
        transactions.add(trans)
        sale = sales["sale_3"]!!
        stock = stocks["product_3"]!!
        trans =
            TransactionInfo(
                sale,
                stock,
                quantitySold = 50,
                amountPaid = 63.50,
                changeLeft = 8.90,
                productPrice = 56.54
            )
        transactions.add(trans)

        sale = sales["sale_3"]!!
        stock = stocks["product_3"]!!
        trans =
            TransactionInfo(
                sale,
                stock,
                quantitySold = 50,
                amountPaid = 63.50,
                changeLeft = 8.90,
                productPrice = 56.54
            )
        transactions.add(trans)

        sale = sales["sale_3"]!!
        stock = stocks["product_3"]!!
        trans =
            TransactionInfo(
                sale,
                stock,
                quantitySold = 50,
                amountPaid = 63.50,
                changeLeft = 8.90,
                productPrice = 56.54
            )
        transactions.add(trans)

    }
}