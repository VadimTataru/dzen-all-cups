package com.fox.dzenallcups.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fox.dzenallcups.data.MockCategories
import com.fox.dzenallcups.data.model.Category

class MainActivityViewModel: ViewModel() {

    private val categoriesLiveData = MutableLiveData<MutableList<Category>>()
    private val selectedCategoryAmount = MutableLiveData<Int>()
    private var amount = 0

    var isContinueBtnVisible = false

    fun observeCategories() = categoriesLiveData
    fun observeSelectedCategoryAmount() = selectedCategoryAmount

    init {
        Log.d("TAG", "ViewModel init")
        categoriesLiveData.value = MockCategories.categories
        selectedCategoryAmount.value = 0
    }

    fun setCheckedState(category: Category){
        category.checked = !category.checked
        if(category.checked)
            amount++
        else
            amount--

        selectedCategoryAmount.value = amount
        setBtnVisible()
    }

    private fun setBtnVisible() {
        isContinueBtnVisible = amount > 0
    }
}