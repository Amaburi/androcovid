package com.example.covidd_05_arsyad.api

import com.example.covidd_05_arsyad.api.model.IndonesiaResponse
import com.example.covidd_05_arsyad.api.model.ProvinceResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET ("casenumber.json")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET ("casenumberprovince.json")
    fun getProvince(): Call<ArrayList<ProvinceResponse>>
}