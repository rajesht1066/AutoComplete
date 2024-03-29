package com.example.autocomplete.model.interfaces

import com.example.autocomplete.model.data.City
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CustomApi {
    @GET
    suspend fun getCity(@Url url:String) : Response<City>
}