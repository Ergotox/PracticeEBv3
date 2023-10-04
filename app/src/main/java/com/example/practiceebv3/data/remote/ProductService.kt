package com.example.practiceebv3.data.remote

import com.example.practiceebv3.data.model.Product
import com.example.practiceebv3.data.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductService {

    @GET("search")
    fun searchByName(
        @Query("query") textQuery: String = "pizza",
        @Query("number") number: Int = 50,
        @Query("apiKey") apiToken: String = "ff767bd4315b4d388b050fc37024eb96"
    ): Call<ProductResponse>


    @GET("{id_product}?apiKey={api_token}")
    fun searchById(
        @Path("id_product") idProduct: Int,
        @Path("api_token") apiToken: String="ff767bd4315b4d388b050fc37024eb96"
    ): Call<Product>

}