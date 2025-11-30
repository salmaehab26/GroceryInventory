package com.example.groceryinventory.data.mapper

import com.example.groceryinventory.data.dataSource.localDataSource.ProductEntity
import com.example.groceryinventory.domain.algorithm.Algorithms
import com.example.groceryinventory.domain.model.Product

fun ProductEntity.toDomain(algorithms: Algorithms): Product {
    val totalSold = last7DaysSales.sum()
    val remainingQty = algorithms.calculateRemainingQuantity(totalQuantity, last7DaysSales)
    val remainingPercent = algorithms.calculateRemainingPercentage(totalQuantity, remainingQty)
    val predicted = algorithms.predictNextDay(last7DaysSales)
    val status = algorithms.calculateStockStatus(remainingPercent)

    return Product(
        id = id,
        name = name,
        totalQuantity = totalQuantity,
        last7DaysSales = last7DaysSales,
        predictedNextDay = predicted,
        remainingQuantity = remainingQty,
        stockStatus = status,
        remainingPercentage = remainingPercent,
        image = image
    )
}
