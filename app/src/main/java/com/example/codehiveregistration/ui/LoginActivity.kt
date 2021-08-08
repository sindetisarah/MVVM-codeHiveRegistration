package com.example.codehiveregistration.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels
import com.example.codehiveregistration.R
import com.example.codehiveregistration.databinding.ActivityLoginBinding

import com.example.codehiveregistration.viewmodel.LoginViewModel


class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    //create a variable from a shared preference

    val loginViewModel:LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)




        }
    }
