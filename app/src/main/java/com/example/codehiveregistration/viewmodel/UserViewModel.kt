package com.example.codehiveregistration.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.models.RegistrationRequest
import com.example.codehiveregistration.models.RegistrationResponse
import com.example.codehiveregistration.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {


       var registrationLiveData = MutableLiveData<RegistrationResponse>()
       var  regError = MutableLiveData<String>()
       val userRepository = UserRepository()
        fun registerUser(registrationRequest: RegistrationRequest){
            viewModelScope.launch {
                val response = userRepository.registerUser(registrationRequest)
                if (response.isSuccessful){
                    registrationLiveData.postValue(response.body())
                }
                else{
                    regError.postValue(response.errorBody()?.string())
                }
            }
        }
    }
