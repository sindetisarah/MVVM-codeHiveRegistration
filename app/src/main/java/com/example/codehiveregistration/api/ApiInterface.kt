package com.example.codehiveregistration.api

import com.example.codehiveregistration.models.LoginRequest
import com.example.codehiveregistration.models.LoginResponse
import com.example.codehiveregistration.models.RegistrationRequest
import com.example.codehiveregistration.models.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface
{
    @POST("/student/register")
    fun registerStudent(@Body registrationRequest: RegistrationRequest):Call<RegistrationResponse>

    @POST("/students/login")
    fun loginStudent(@Body logInRequest:LoginRequest): Call<LoginResponse>


}