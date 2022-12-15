package com.fox.dzenallcups

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fox.dzenallcups.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtons()
    }

    private fun initButtons() {
        binding.btnLatter.setOnClickListener {
            Toast.makeText(this, "Выбрать позже", Toast.LENGTH_SHORT).show()
        }

        binding.btnContinue.setOnClickListener {
            Toast.makeText(this, "Продолжить", Toast.LENGTH_SHORT).show()
        }
    }
}