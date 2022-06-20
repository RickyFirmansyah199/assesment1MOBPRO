package com.d3if3116.hitung_luassegitiga.network

import com.d3if3116.hitung_luassegitiga.model.Glossarium
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL ="https://gist.githubusercontent.com/RickyFirmansyah199/439ef370548bd2f772f178be10d7f582/raw/8fbf57bb555f74d6cc0c27d1bc82aee77f36a621/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface Segi3ApiService {

    @GET("Jenis_Segitiga.json")
    suspend fun getSegi3(): List<Glossarium>
}

object Segi3Api {
    val service: Segi3ApiService by lazy {
        retrofit.create(Segi3ApiService::class.java)
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }