package com.example.codehiveregistration.models

data class LoginResponse(
    var message: String,
    var accessToken: String,
    var studentId: String
)
