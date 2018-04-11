package nico.rss.com.pp.rest

import nico.rss.com.pp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

public class RetrofitClientt {
    companion object {
        private var retrofit: Retrofit? = null
        fun getClient(baseUrl: String): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
                        .client(getHTTPClient())
                        .build()
            }
            return retrofit
        }

        fun getHTTPClient(): OkHttpClient? {

            return OkHttpClient().newBuilder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                    })
                    .build()
        }
    }



}