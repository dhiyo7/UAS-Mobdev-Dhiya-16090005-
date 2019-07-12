package com.dhiyo.formulir.services

import com.dhiyo.formulir.models.Peserta
import com.dhiyo.formulir.models.User
import com.dhiyo.formulir.networks.BaseListResponse
import com.dhiyo.formulir.networks.BaseResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {

    @FormUrlEncoded
    @POST("api/user/login")
    fun login(@Field("email") email : String, @Field("password") password : String) : Call<BaseResponse<User>>

    @FormUrlEncoded
    @POST("api/user/register")
    fun register(@Field("name") n : String, @Field("email") e : String,@Field("password") p : String) : Call<BaseResponse<User>>

    @FormUrlEncoded
    @POST("api/user/complaint")
    fun insert(@Header("Authorization") api_token: String, @Field("title") title : String,
               @Field("message") message : String,
               @Field("input1") input1 : String,
               @Field("input2") input2  : String) : Call<BaseResponse<Peserta>>


    @GET("api/user/complaint")
    fun all(@Header("Authorization") api_token : String) : Call<BaseListResponse<Peserta>>


}