package com.example.groceryinventory.data.repository

import com.example.groceryinventory.domain.model.Product
import kotlinx.coroutines.flow.Flow



interface IProductRepository {
    suspend fun seedDataIfNeeded()

    fun getAllProducts(): Flow<List<Product>>
}