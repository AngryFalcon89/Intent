package com.example.intent

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.intent.databinding.ActivityOtherBinding

class OtherActivity : AppCompatActivity() {
    val binding by lazy{
        ActivityOtherBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        var userData = intent.getSerializableExtra("USER_DATA") as UserData

        binding.name.text = userData.name
        binding.age.text = userData.age.toString()
        binding.phone.text = userData.phone
        binding.email.text = userData.email
        setContentView(binding.root)
    }
}