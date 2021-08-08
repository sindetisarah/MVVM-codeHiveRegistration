package com.example.codehiveregistration.repository

import com.example.codehiveregistration.api.ApiClient
import com.example.codehiveregistration.api.ApiInterface
import com.example.codehiveregistration.models.LoginRequest
import com.example.codehiveregistration.models.LoginResponse
import com.example.codehiveregistration.models.RegistrationRequest
import com.example.codehiveregistration.models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun registerUser(registrationRequest: RegistrationRequest):
            Response<RegistrationResponse> =
        withContext(Dispatchers.IO) {
            var response = apiInterface.registerStudent(registrationRequest)
        return@withContext response
    }
    suspend fun loginStudent(loginRequest: LoginRequest):Response<LoginResponse> =
        withContext(Dispatchers.IO){
            var response=apiInterface.loginStudent(loginRequest)
            return@withContext response

        }
}