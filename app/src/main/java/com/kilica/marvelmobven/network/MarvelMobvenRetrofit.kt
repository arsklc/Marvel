package com.kilica.marvelmobven.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MarvelMobvenRetrofit @Inject constructor(
    context: Context,
    baseUrl: String
) {
    val loggingInterceptor : HttpLoggingInterceptor by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        interceptor
    }

    val headerInterceptor : Interceptor by lazy {
        Interceptor {
            val request = it.request()
            request.newBuilder().header("gh","jkh")
            return@Interceptor it.proceed(request)
        }
    }

    val client : OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headerInterceptor)
            .addInterceptor(ChuckerInterceptor(context))
            .build()
    }

    val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun <A> create(classType: Class<A>) : A {
        return retrofit.create(classType)
    }
}