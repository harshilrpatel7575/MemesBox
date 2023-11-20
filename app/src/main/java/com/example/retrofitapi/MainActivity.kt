package com.example.retrofitapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.retrofitapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

        binding.btnNewMeme.setOnClickListener{
            getData()
        }

    }

    private fun getData() {
        Retrofitinstance.ApiInstance.getData().enqueue(object : Callback<responseDataclass?> {
            override fun onResponse(
                call: Call<responseDataclass?>,
                response: Response<responseDataclass?>
            ) {
                binding.memeTitle.text= response.body()?.title
                binding.memeAuther.text=response.body()?.author
                Glide.with(this@MainActivity).load(response.body()?.url).into(binding.memeimage)


            }

            override fun onFailure(call: Call<responseDataclass?>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}