package com.example.codehiveregistration.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import com.example.codehiveregistration.R

import com.example.codehiveregistration.databinding.ActivityMainBinding
import com.example.codehiveregistration.models.RegistrationRequest

import com.example.codehiveregistration.viewmodel.UserViewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    //instance of a userViewModel annotation that allows one to create an instance of a model using the factory pattern
    val userViewModel: UserViewModel by viewModels()

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nationality = arrayOf("Kenyan", "Ugandan", "Rwandese", "South Sudanes")
        var nationalityAdapter = ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationality)
        nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spNationality.adapter = nationalityAdapter


    }

    override fun onResume() {


        super.onResume()
        binding.btnRegister.setOnClickListener {


            if (binding.etName.text.toString().isEmpty() || binding.etDob.text.toString()
                    .isEmpty() || binding.etEmail.text.toString().isEmpty() || binding.etPassword.text.toString()
                    .isEmpty() || binding.etPhone.text.toString().isEmpty()
            ) {
                binding.etName.setError("Please input Name!")
                binding.etDob.setError("Please input Date of Birth!")
                binding.etEmail.setError("Please input Email!")
                binding.etPhone.setError("Please input Phone!")
                binding.etPassword.setError("Please input Password!")
            }

             var name = binding.etName.text.toString()
             var date_of_birth = binding.etDob.text.toString()
             var email = binding.etEmail.text.toString()
             var phone_number = binding.etPhone.text.toString()
             var password = binding.etPassword.text.toString()
             var spNationality = binding.spNationality.selectedItem.toString().uppercase()


            var registrationRequest = RegistrationRequest(
            name = name,
            phoneNumber = phone_number,
            email = email,
            nationality = spNationality,
            dateOfBirth = date_of_birth,
            password = password
        )

            userViewModel.registerUser(registrationRequest  )
            var intent=Intent(baseContext,LoginActivity::class.java)
            startActivity(intent)
        }
        userViewModel.registrationLiveData.observe(this,{regResponse->
            if (!regResponse.studentId.isNullOrEmpty()){
                Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG).show()
            }

        })
        userViewModel.regError.observe(this, { error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })

    }


//        //After creating instance of userView Model




}
