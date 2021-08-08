package com.example.codehiveregistration.models

import android.content.Context
import android.content.SharedPreferences
import com.example.codehiveregistration.R

class SessionManager {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val STUDENT_TOKEN = "ACCESS_TOKEN"
    }

    fun saveAuth(token: String) {
        val editor = prefs.edit()
        editor.putString(STUDENT_TOKEN, token)
        editor.apply()
    }

    fun fetchAuth: String? {
        return prefs.getString(STUDENT_TOKEN, null)
    }
}