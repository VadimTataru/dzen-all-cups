package com.fox.dzenallcups

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.LayoutDirection
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.fox.dzenallcups.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initButtons()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initButtons() {
        binding.btnLatter.setOnClickListener {
            Toast.makeText(this, "Выбрать позже", Toast.LENGTH_SHORT).show()
            addChip("Тестим")
        }

        binding.btnContinue.setOnClickListener {
            Toast.makeText(this, "Продолжить", Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun addChip(title: String) {
        val chip = Chip(this)
        chip.apply {
            text = title
            isCheckable = true
            isCloseIconVisible = false
            isCheckedIconVisible = false
            isChipIconVisible = true
            chipCornerRadius = 36f
            setChipIconResource(R.drawable.chip_checked_icon)
            setChipBackgroundColorResource(R.color.chip_background_color)
            setTextColor(getColor(R.color.chip_text_color))
            layoutDirection = View.LAYOUT_DIRECTION_RTL
        }

        binding.chipGroup.addView(chip)
    }
}