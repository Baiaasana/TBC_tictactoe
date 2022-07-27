package com.example.x_0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.x_0.databinding.ActivityMain1Binding

class MainActivity1 : AppCompatActivity() {

    private lateinit var binding: ActivityMain1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val number = binding.appCompatEditText.text.toString()
        binding.btnStart.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("number", number)
            startActivity(intent)
        }

//        binding.btnStart.setOnClickListener {
//            val intent2 = Intent(this, MainActivity3::class.java)
//            val intent = Intent(this, MainActivity2::class.java)
//        if (number=="3") startActivity(intent)
//            else if (number=="4") startActivity(intent2)
//        }

    }
}