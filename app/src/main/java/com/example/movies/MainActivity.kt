package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies.landingPage.LandingPageFragment
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = LandingPageFragment()
        fragmentTransaction.add(R.id.main_container, fragment)
        fragmentTransaction.commit()

    }

    object RetrofitBuilder {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/")
            .client(
                OkHttpClient.Builder()
                    .build()
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

}
