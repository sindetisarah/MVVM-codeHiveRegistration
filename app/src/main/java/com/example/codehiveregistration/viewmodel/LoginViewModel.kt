package com.example.codehiveregistration.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.models.LoginRequest
import com.example.codehiveregistration.models.LoginResponse
import com.example.codehiveregistration.repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel(){
    var LoginLiveData = MutableLiveData<LoginResponse>()
    var  loginError = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun loginStudent(loginRequest: LoginRequest){

        viewModelScope.launch {
            var response = userRepository.loginStudent(loginRequest)
            if (response.isSuccessful){
                LoginLiveData.postValue(response.body())
            }
            else{
                loginError.postValue(response.errorBody()?.string())
            }
        }
    }
}