package com.example.groceryinventory.data.dataSource.localDataSource

import androidx.annotation.DrawableRes
import com.example.groceryinventory.R
object ProductImages {
    @DrawableRes
    fun getImageForProduct(productId: Int): Int {
        return when (productId) {
            1 -> R.drawable.rice
            2 -> R.drawable.suger
            3 -> R.drawable.cooking_oil
            4 -> R.drawable.flour
            5 -> R.drawable.milk
            6 -> R.drawable.bread
            7 -> R.drawable.cheese
            8 -> R.drawable.eggs
            9 -> R.drawable.butter
            10 -> R.drawable.yougurt
            11 -> R.drawable.juice
            12 -> R.drawable.water
            13 -> R.drawable.apple
            14 -> R.drawable.banana
            15 -> R.drawable.orange
            16 -> R.drawable.tomato
            17 -> R.drawable.potato
            18 -> R.drawable.onion
            19 -> R.drawable.carrot
            20 -> R.drawable.cucamper
            21 -> R.drawable.chicken
            22 -> R.drawable.meat
            23 -> R.drawable.fish
            24 -> R.drawable.pasta
            25 -> R.drawable.salt
            26 -> R.drawable.coffee
            27 -> R.drawable.tea
            28 -> R.drawable.chochlet
            29 -> R.drawable.biscut
            else -> R.drawable.ic_launcher_foreground
        }
    }
}