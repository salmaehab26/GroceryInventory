package com.example.groceryinventory.domain.model


data class Product(
    val id: Int,
    val name: String,
    val totalQuantity: Int,
    val last7DaysSales: List<Int>,
    val predictedNextDay: Int,
    val remainingQuantity: Int,
    val stockStatus: StockStatus,
    val remainingPercentage: Double,
    val image:Int
)