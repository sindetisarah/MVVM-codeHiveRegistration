package com.example.codehiveregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.codehiveregistration.api.ApiClient
import com.example.codehiveregistration.api.ApiInterface
import com.example.codehiveregistration.models.RegistrationRequest
import com.example.codehiveregistration.models.RegistrationResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var etName = findViewById<EditText>(R.id.etName)
        var etDob = findViewById<EditText>(R.id.etDob)
        var spNationality = findViewById<Spinner>(R.id.spNationality)
        var etpassword = findViewById<EditText>(R.id.etPassword)
        var etEmail = findViewById<EditText>(R.id.etEmail)
        var etphone = findViewById<EditText>(R.id.etPhone)
        var btnRegister = findViewById<Button>(R.id.btnRegister)

        var nationalities = arrayOf("Kenyan", "Ugandan", "Rwandan", "South Sudanese")
        var nationalitiesAdapter =
            ArrayAdapter(baseContext, android.R.layout.simple_spinner_item, nationalities)
        nationalitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spNationality.adapter = nationalitiesAdapter

        btnRegister.setOnClickListener {
            if (etName.text.toString().isEmpty() || etDob.text.toString()
                    .isEmpty() || etEmail.text.toString().isEmpty() || etpassword.text.toString()
                    .isEmpty() || etphone.text.toString().isEmpty()
            ) {
                etName.setError("Please input name")
                etDob.setError("Please input Date of Birth")
                etEmail.setError("Please input email")
                etphone.setError("Please input phone")
                etpassword.setError("Please input id")
            }


            var name = etName.text.toString()
            var date_of_birth = etDob.text.toString()
            var email = etEmail.text.toString()
            var phone_number = etphone.text.toString()
            var password = etpassword.text.toString()

            var nationality = spNationality.selectedItem.toString()


            var registrationRequest = RegistrationRequest(
                name = name,
                phoneNumber = phone_number,
                email = email,
                nationality = nationality.toUpperCase(),
                dateOfBirth = date_of_birth,
                password = password
            )


            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.registerStudent(registrationRequest)
            request.enqueue(object : Callback<RegistrationResponse?> {
                override fun onResponse(
                    call: Call<RegistrationResponse?>,
                    response: Response<RegistrationResponse?>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(baseContext,"Registration Successful",Toast.LENGTH_LONG).show()
                        var intent = Intent(baseContext, LoginActivity::class.java)
                        startActivity(intent)


                    }
                    else{
                        try {
                            val error = JSONObject(response.errorBody()!!.string())
                            Toast.makeText(baseContext,error.toString(), Toast.LENGTH_LONG).show()
                        }
                        catch (e:Exception){
                            Toast.makeText(baseContext,e.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }

                override fun onFailure(call: Call<RegistrationResponse?>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_SHORT).show()
                }
            })


        }

    }
    data class ApiError(var errors:List<String>)

}
