package com.fox.dzenallcups

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.LayoutDirection
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.fox.dzenallcups.data.model.Category
import com.fox.dzenallcups.databinding.ActivityMainBinding
import com.fox.dzenallcups.presentation.MainActivityViewModel
import com.google.android.material.chip.Chip
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        createStartList()
        initButtons()
        binding.btnContinue.isActivated = false

        binding.btnLatter.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_rtl_anim))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initButtons() {
        viewModel.observeSelectedCategoryAmount().observe(this) {
            if(it > 0) {
                binding.btnContinue.isActivated = false
                binding.btnContinue.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_btu_anim))
            }
        }

        binding.btnLatter.setOnClickListener {
            Toast.makeText(this, "Выбрать позже", Toast.LENGTH_SHORT).show()
        }

        binding.btnContinue.setOnClickListener {
            Toast.makeText(this, "Продолжить", Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun createStartList() {
        viewModel.observeCategories().observe(this) { categories ->
            for (item in categories) {
                addChip(item)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun addChip(category: Category) {
        val chip = Chip(this)
        chip.apply {
            text = category.title
            isCheckable = true
            isChecked = category.checked
            isCloseIconVisible = false
            isCheckedIconVisible = false
            isChipIconVisible = true
            chipCornerRadius = 36f
            setChipIconResource(R.drawable.chip_checked_icon)
            setChipBackgroundColorResource(R.color.chip_background_color)
            setTextColor(getColor(R.color.chip_text_color))
            layoutDirection = View.LAYOUT_DIRECTION_RTL

            setOnClickListener {
                viewModel.setCheckedState(category)
            }
        }
        binding.chipGroup.addView(chip)
        setChipAnimation(chip)
    }

    private fun setChipAnimation(chip: Chip) {
        val rand = Random
        if(rand.nextInt(3) % 2 == 0)
            chip.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_ltr_anim))
        else
            chip.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_rtl_anim))
    }
}