package com.example.codehiveregistration.api

import com.example.codehiveregistration.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface
{
    @POST("/student/register")
    suspend fun registerStudent(@Body registrationRequest: RegistrationRequest):Response<RegistrationResponse>

    @POST("/students/login")
    suspend fun loginStudent(@Body logInRequest:LoginRequest): Response<LoginResponse>

    @GET("/courses")
    suspend fun studentCourses(@Header("Authorization") token: String): Response<List<CourseResponse>>


}