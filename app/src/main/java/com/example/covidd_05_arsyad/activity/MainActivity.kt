package com.example.covidd_05_arsyad.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.covidd_05_arsyad.api.RetrofitClient
import com.example.covidd_05_arsyad.api.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.covidd_05_arsyad.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showIndonesia()
        btnProvince.setOnClickListener {
            Intent(this@MainActivity, ProvinceActivity::class.java).also {
                startActivity(it)
            }
        }
    }
    private fun showIndonesia(){
        RetrofitClient.instance.getIndonesia().enqueue(object :
            Callback<ArrayList<IndonesiaResponse>> {
            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                val Indonesia = response.body()?.get(0)
                val positive = Indonesia?.positif
                val hospitialized = Indonesia?.dirawat
                val death = Indonesia?.meninggal
                val recover = Indonesia?.sembuh

                val cassPositive : TextView = findViewById(R.id.tvPositive)
                cassPositive.text= positive
                val casehospitialized :TextView = findViewById(R.id.tvHospitalized)
                casehospitialized.text= hospitialized
                val caseDeath :TextView = findViewById(R.id.tvDeath)
                caseDeath.text= death
                val caserecover :TextView = findViewById(R.id.tvRecover)
                caserecover.text= recover
            }

            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"${t.message}",Toast.LENGTH_SHORT).show()
            }

        })
    }
}