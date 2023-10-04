package com.example.practiceebv3.data.model

import com.google.gson.annotations.SerializedName


data class ProductResponse(
    @SerializedName("results")
    val products: List<Product>
)
data class Product(
    val id: Int,
    val title: String,
    val image: ProductImage,
    var isFavorite: Boolean
)
data class ProductImage(
    var url: String
)