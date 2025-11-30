package com.example.groceryinventory.data.dataSource.localDataSource
import com.example.groceryinventory.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

class DataSeeder @Inject constructor(private val productDao: ProductDao) {

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
            ProductEntity(1, "Rice", 25, listOf(2, 3, 1, 2, 2, 3, 2), R.drawable.rice),
            ProductEntity(2, "Sugar", 20, listOf(1, 1, 2, 1, 1, 1, 1),R.drawable.suger),
            ProductEntity(3, "Cooking Oil", 15, listOf(1, 1, 1, 1, 1, 1, 1),R.drawable.cooking_oil),
            ProductEntity(4, "Flour", 30, listOf(3, 4, 2, 3, 3, 4, 3),R.drawable.flour),
            ProductEntity(5, "Milk", 30, listOf(4, 5, 4, 4, 5, 4, 4),R.drawable.milk),
            ProductEntity(6, "Bread", 40, listOf(10, 12, 8, 11, 9, 10, 13),R.drawable.bread),
            ProductEntity(7, "Cheese", 20, listOf(2, 3, 2, 4, 3, 2, 3),R.drawable.cheese),
            ProductEntity(8, "Eggs", 50, listOf(5, 6, 4, 5, 6, 5, 7),R.drawable.eggs),
            ProductEntity(9, "Butter", 15, listOf(2, 2, 1, 2, 3, 2, 2),R.drawable.butter),
            ProductEntity(10, "Yogurt", 25, listOf(3, 4, 3, 3, 4, 3, 4),R.drawable.yougurt),
            ProductEntity(11, "Juice", 30, listOf(4, 5, 3, 4, 5, 4, 5),R.drawable.juice),
            ProductEntity(12, "Water", 60, listOf(8, 9, 7, 8, 10, 8, 9),R.drawable.water),
            ProductEntity(13, "Apple", 40, listOf(5, 6, 4, 5, 6, 5, 7),R.drawable.apple),
            ProductEntity(14, "Banana", 35, listOf(4, 5, 3, 4, 5, 4, 6),R.drawable.banana),
            ProductEntity(15, "Orange", 30, listOf(3, 4, 3, 4, 4, 3, 5),R.drawable.orange),
            ProductEntity(16, "Tomato", 25, listOf(3, 4, 2, 3, 4, 3, 4),R.drawable.tomato),
            ProductEntity(17, "Potato", 50, listOf(6, 7, 5, 6, 7, 6, 8),R.drawable.potato),
            ProductEntity(18, "Onion", 35, listOf(4, 5, 3, 4, 5, 4, 5),R.drawable.onion),
            ProductEntity(19, "Carrot", 28, listOf(3, 4, 2, 3, 4, 3, 4),R.drawable.carrot),
            ProductEntity(20, "Cucumber", 22, listOf(2, 3, 2, 3, 3, 2, 3),R.drawable.cucamper),
            ProductEntity(21, "Chicken", 18, listOf(2, 3, 2, 2, 3, 2, 3),R.drawable.chicken),
            ProductEntity(22, "Beef", 15, listOf(2, 2, 1, 2, 2, 2, 2),R.drawable.meat),
            ProductEntity(23, "Fish", 12, listOf(1, 2, 1, 2, 2, 1, 2),R.drawable.fish),
            ProductEntity(24, "Pasta", 35, listOf(4, 5, 3, 4, 5, 4, 5),R.drawable.pasta),
            ProductEntity(25, "Salt", 20, listOf(1, 1, 1, 1, 1, 1, 1),R.drawable.salt),
            ProductEntity(26, "Coffee", 18, listOf(2, 3, 2, 2, 3, 2, 3),R.drawable.coffee),
            ProductEntity(27, "Tea", 25, listOf(3, 4, 2, 3, 4, 3, 4),R.drawable.tea),
            ProductEntity(28, "Chocolate", 30, listOf(4, 5, 3, 4, 5, 4, 5),R.drawable.chochlet),
            ProductEntity(29, "Biscuits", 28, listOf(3, 4, 3, 4, 4, 3, 4),R.drawable.f17b915f43f131b2dd1e5c69c2110b6e),
        )
    }
}
