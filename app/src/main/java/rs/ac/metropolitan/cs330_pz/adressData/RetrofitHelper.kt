package rs.ac.metropolitan.cs330_pz.adressData

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rs.ac.metropolitan.data.Constants


object RetrofitHelper {
    fun getInstance(): Retrofit {
        val httpClient = OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}