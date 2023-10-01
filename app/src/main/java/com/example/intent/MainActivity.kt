package com.example.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var intent = Intent(this@MainActivity, OtherActivity::class.java)
            var userData = UserData()
            userData.name = binding.name.text.toString()
            userData.age = binding.age.text.toString().toByte()
            userData.phone = binding.phone.text.toString()
            userData.email = binding.email.text.toString()

            intent.putExtra("USER_DATA", userData)

            startActivity(intent)
        }

        binding.webbutton.setOnClickListener {
            var intent = Intent()
            intent.action = Intent.ACTION_VIEW

            intent.setData(Uri.parse("https://www.google.com/"))
            
            startActivity(intent)
        }
    }
}