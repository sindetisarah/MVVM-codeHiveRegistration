package com.example.codehiveregistration.repository


    import com.example.codehiveregistration.api.ApiClient
    import com.example.codehiveregistration.api.ApiInterface
    import com.example.codehiveregistration.models.CourseResponse
    import com.example.codehiveregistration.models.SessionManager

    import com.example.codehiveregistration.models.*
    import kotlinx.coroutines.Dispatchers
    import kotlinx.coroutines.withContext
    import retrofit2.Response

class CourseRepository {
        lateinit var sessionManager: SessionManager
        var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
        suspend fun courses(): Response<List<CourseResponse>> =
            withContext(Dispatchers.IO){
                var response=apiInterface.studentCourses(token="Bearer ${sessionManager.fetchAuth()}")
                return@withContext response

            }
    }