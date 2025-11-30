package com.example.groceryinventory.domain.useCase

import com.example.groceryinventory.data.repository.IProductRepository
import com.example.groceryinventory.domain.model.Product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



class GetProductsUseCase @Inject constructor(
    private val repository: IProductRepository
) {
    operator fun invoke(): Flow<List<Product>> {
        return repository.getAllProducts()
    }
}
