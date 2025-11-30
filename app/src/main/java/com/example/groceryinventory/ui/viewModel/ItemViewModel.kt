package com.example.groceryinventory.ui.viewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.groceryinventory.data.repository.IProductRepository
import com.example.groceryinventory.domain.algorithm.Algorithms
import com.example.groceryinventory.domain.model.Product
import com.example.groceryinventory.domain.useCase.GetProductsUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

import kotlinx.coroutines.flow.combine

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: IProductRepository,
    private val algorithms: Algorithms
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    private val _isSortedAscending = MutableStateFlow(false)
    private val _isSortedDescending = MutableStateFlow(false)

    init {
        viewModelScope.launch {
            repository.seedDataIfNeeded()
        }}
    val products: StateFlow<List<Product>> = combine(
        repository.getAllProducts(),
        _searchQuery,
        _isSortedAscending,
        _isSortedDescending
    ) { list, query, asc, desc ->
        val filtered = if (query.isEmpty()) list else algorithms.getItemsStartingWith(list, query)
        when {
            asc -> algorithms.mergeSortAscending(filtered)
            desc -> algorithms.quickSortDescending(filtered)
            else -> filtered
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
        _isSortedAscending.value = false
        _isSortedDescending.value = false
    }

    fun onSortAscending() {
        _isSortedAscending.value = true
        _isSortedDescending.value = false
    }

    fun onSortDescending() {
        _isSortedDescending.value = true
        _isSortedAscending.value = false
    }
}
