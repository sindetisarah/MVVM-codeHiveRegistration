package com.example.codehiveregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.codehiveregistration.api.ApiClient
import com.example.codehiveregistration.api.ApiInterface
import com.example.codehiveregistration.models.LoginRequest
import com.example.codehiveregistration.models.LoginResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var etpassword=findViewById<EditText>(R.id.etPassword)
        var etemail=findViewById<EditText>(R.id.etEmail)
        var btnLogin=findViewById<Button>(R.id.btnLogin)


        btnLogin.setOnClickListener {
            var password=etpassword.text.toString()
            var email=etemail.text.toString()


            if (password.isEmpty()||email.isEmpty()){
                etpassword.setError("Please input password")
                etemail.setError("Please input email")
            }

            var loginRequest=LoginRequest(
                email=email,
                password=password
            )

            val retrofit = ApiClient.buildApiClient(ApiInterface ::class.java)
            var request = retrofit.loginStudent(loginRequest)
            request.enqueue(object : Callback<LoginResponse?> {
                override fun onResponse(
                    call: Call<LoginResponse?>,
                    response: Response<LoginResponse?>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(baseContext,"Login Successful", Toast.LENGTH_LONG).show()
                        var intent = Intent(baseContext,WelcomeActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        try {
                            val error = JSONObject(response.errorBody()!!.string())
                            Toast.makeText(baseContext,error.toString(), Toast.LENGTH_LONG).show()
                        }
                        catch (e: Exception){
                            Toast.makeText(baseContext,e.message, Toast.LENGTH_LONG).show()
                        }
                    }                }

                override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                            Toast.makeText(baseContext,t.message,Toast.LENGTH_SHORT).show()                }
            })


        }
    }
}