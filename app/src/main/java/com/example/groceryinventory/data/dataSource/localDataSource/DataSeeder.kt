package com.example.groceryinventory.data.dataSource.localDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataSeeder(private val productDao: ProductDao) {

    suspend fun seedInitialDataIfEmpty() {
        withContext(Dispatchers.IO) {
            val count = productDao.getProductCount()
            if (count == 0) {
                productDao.insertProducts(getSampleProducts())
            }
        }
    }

    private fun getSampleProducts(): List<ProductEntity> {
        return listOf(
            ProductEntity(1, "Rice", 25, listOf(2, 3, 1, 2, 2, 3, 2)),
            ProductEntity(2, "Sugar", 20, listOf(1, 1, 2, 1, 1, 1, 1)),
            ProductEntity(3, "Cooking Oil", 15, listOf(1, 1, 1, 1, 1, 1, 1)),
            ProductEntity(4, "Flour", 30, listOf(3, 4, 2, 3, 3, 4, 3)),
            ProductEntity(5, "Milk", 30, listOf(4, 5, 4, 4, 5, 4, 4)),
            ProductEntity(6, "Bread", 40, listOf(10, 12, 8, 11, 9, 10, 13)),
            ProductEntity(7, "Cheese", 20, listOf(2, 3, 2, 4, 3, 2, 3)),
            ProductEntity(8, "Eggs", 50, listOf(5, 6, 4, 5, 6, 5, 7)),
            ProductEntity(9, "Butter", 15, listOf(2, 2, 1, 2, 3, 2, 2)),
            ProductEntity(10, "Yogurt", 25, listOf(3, 4, 3, 3, 4, 3, 4)),
            ProductEntity(11, "Juice", 30, listOf(4, 5, 3, 4, 5, 4, 5)),
            ProductEntity(12, "Water", 60, listOf(8, 9, 7, 8, 10, 8, 9)),
            ProductEntity(13, "Apple", 40, listOf(5, 6, 4, 5, 6, 5, 7)),
            ProductEntity(14, "Banana", 35, listOf(4, 5, 3, 4, 5, 4, 6)),
            ProductEntity(15, "Orange", 30, listOf(3, 4, 3, 4, 4, 3, 5)),
            ProductEntity(16, "Tomato", 25, listOf(3, 4, 2, 3, 4, 3, 4)),
            ProductEntity(17, "Potato", 50, listOf(6, 7, 5, 6, 7, 6, 8)),
            ProductEntity(18, "Onion", 35, listOf(4, 5, 3, 4, 5, 4, 5)),
            ProductEntity(19, "Carrot", 28, listOf(3, 4, 2, 3, 4, 3, 4)),
            ProductEntity(20, "Cucumber", 22, listOf(2, 3, 2, 3, 3, 2, 3)),
            ProductEntity(21, "Chicken", 18, listOf(2, 3, 2, 2, 3, 2, 3)),
            ProductEntity(22, "Beef", 15, listOf(2, 2, 1, 2, 2, 2, 2)),
            ProductEntity(23, "Fish", 12, listOf(1, 2, 1, 2, 2, 1, 2)),
            ProductEntity(24, "Pasta", 35, listOf(4, 5, 3, 4, 5, 4, 5)),
            ProductEntity(25, "Salt", 20, listOf(1, 1, 1, 1, 1, 1, 1)),
            ProductEntity(26, "Coffee", 18, listOf(2, 3, 2, 2, 3, 2, 3)),
            ProductEntity(27, "Tea", 25, listOf(3, 4, 2, 3, 4, 3, 4)),
            ProductEntity(28, "Chocolate", 30, listOf(4, 5, 3, 4, 5, 4, 5)),
            ProductEntity(29, "Biscuits", 28, listOf(3, 4, 3, 4, 4, 3, 4)),
        )
    }
}
