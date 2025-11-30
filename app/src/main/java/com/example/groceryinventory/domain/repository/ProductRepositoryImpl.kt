package com.example.groceryinventory.domain.repository
import com.example.groceryinventory.data.dataSource.localDataSource.DataSeeder
import com.example.groceryinventory.data.dataSource.localDataSource.ProductDao
import com.example.groceryinventory.data.mapper.toDomain
import com.example.groceryinventory.data.repository.IProductRepository
import com.example.groceryinventory.domain.algorithm.Algorithms
import com.example.groceryinventory.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao,
    private val dataSeeder: DataSeeder,
    private val algorithms: Algorithms

) : IProductRepository {


    override suspend fun seedDataIfNeeded() {
        dataSeeder.seedInitialDataIfEmpty()

    }

    override fun getAllProducts(): Flow<List<Product>> {
        return productDao.getAllProducts().map { entities ->
            entities.map { it.toDomain(algorithms) }
        }
    }
}
