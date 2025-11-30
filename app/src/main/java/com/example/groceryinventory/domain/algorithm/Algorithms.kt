package com.example.groceryinventory.domain.algorithm

import com.example.groceryinventory.domain.model.Product
import com.example.groceryinventory.domain.model.StockStatus
import javax.inject.Inject

class Algorithms @Inject constructor() {

    fun predictNextDay(arr: List<Int>): Int {
        if (arr.isEmpty()) return 0
        return arr.sum() / arr.size
    }

    fun calculateRemainingQuantity(totalQuantity: Int, last7DaysSales: List<Int>): Int {
        val totalSold = last7DaysSales.sum()
        return (totalQuantity - totalSold).coerceAtLeast(0)
    }

    fun calculateRemainingPercentage(totalQuantity: Int, remainingQuantity: Int): Double {
        return if (totalQuantity > 0) {
            (remainingQuantity.toDouble() / totalQuantity.toDouble()) * 100
        } else 0.0
    }

    fun calculateStockStatus(remainingPercent: Double): StockStatus {
        return when {
            remainingPercent < 20 -> StockStatus.CRITICAL
            remainingPercent < 50 -> StockStatus.WARNING
            else -> StockStatus.STABLE
        }
    }

    fun binarySearchPrefix(list: List<Product>, prefix: String): Int {
        var left = 0
        var right = list.size - 1
        var result = -1

        while (left <= right) {
            val mid = (left + right) / 2
            val name = list[mid].name.lowercase()

            when {
                name.startsWith(prefix.lowercase()) -> {
                    result = mid
                    right = mid - 1
                }
                name < prefix.lowercase() -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return result
    }
    fun getItemsStartingWith(list: List<Product>, prefix: String): List<Product> {
        val lowerPrefix = prefix.lowercase()
        val sortedList = list.sortedBy { it.name.lowercase() }
        val startIndex = binarySearchPrefix(sortedList, lowerPrefix)
        if (startIndex == -1) return emptyList()

        val results = mutableListOf<Product>()
        var index = startIndex
        while (index < sortedList.size && sortedList[index].name.lowercase().startsWith(lowerPrefix)) {
            results.add(sortedList[index])
            index++
        }
        return list.filter { it in results }
    }




    fun quickSortDescending(list: List<Product>): List<Product> {
        if (list.size < 2) return list
        val pivot = list[list.size / 2].remainingQuantity
        val left = list.filter { it.remainingQuantity > pivot }
        val middle = list.filter { it.remainingQuantity == pivot }
        val right = list.filter { it.remainingQuantity < pivot }
        return quickSortDescending(left) + middle + quickSortDescending(right)
    }
    fun mergeSortAscending(list: List<Product>): List<Product> {
        if (list.size <= 1) return list

        val middle = list.size / 2
        val left = mergeSortAscending(list.subList(0, middle))
        val right = mergeSortAscending(list.subList(middle, list.size))

        return merge(left, right)
    }

    private fun merge(left: List<Product>, right: List<Product>): List<Product> {
        var i = 0
        var j = 0
        val merged = mutableListOf<Product>()

        while (i < left.size && j < right.size) {
            if (left[i].remainingQuantity <= right[j].remainingQuantity) {
                merged.add(left[i])
                i++
            } else {
                merged.add(right[j])
                j++
            }
        }
        while (i < left.size) {
            merged.add(left[i])
            i++
        }
        while (j < right.size) {
            merged.add(right[j])
            j++
        }
        return merged
    }

}