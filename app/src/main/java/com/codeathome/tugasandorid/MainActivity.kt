package com.codeathome.tugasandorid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
   //variabel
    private lateinit var etEmail: EditText
   private lateinit var etPassword: EditText
   private lateinit var buttonLogin: Button

   companion object {
       const val EMAIL = "adinugrahakartiwa@gmail.com"
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inisialisasi variabel
        etEmail = findViewById(R.id.email)
        etPassword = findViewById(R.id.pass)
        buttonLogin = findViewById(R.id.btn_login)

        buttonLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Kode aksi yang ingin Anda lakukan saat tombol diklik
            if (email.isEmpty()){
                etEmail.setError("Tolong isi Email")
                return@setOnClickListener
            }
            if (password.isEmpty()){
                etPassword.setError("Tolong isi Password")
                return@setOnClickListener
            }
            //fungsi login
            login(email)
        }

    }

    private fun login(email: String) {
        val intent = Intent(applicationContext, SecondActivity::class.java)
        intent.putExtra(EMAIL, email)
        startActivity(intent)

    }
}