package com.example.codehiveregistration.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.codehiveregistration.models.CourseResponse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.repository.CourseRepository
import kotlinx.coroutines.launch

class CoursesViewModel: ViewModel() {
    var coursesLiveData = MutableLiveData<List<CourseResponse>>()
    var coursesFailedLiveData = MutableLiveData<String>()
    var coursesRepository = CourseRepository()

    fun coursesList(){
        viewModelScope.launch {
            var response = coursesRepository.courses()
            if (response.isSuccessful){
                coursesLiveData.postValue(response.body())
            }
            else{
                coursesFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}