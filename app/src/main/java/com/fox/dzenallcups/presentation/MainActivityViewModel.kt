package com.fox.dzenallcups.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fox.dzenallcups.data.MockCategories
import com.fox.dzenallcups.data.model.Category

class MainActivityViewModel: ViewModel() {

    private val categoriesLiveData = MutableLiveData<MutableList<Category>>()
    private val selectedCategoryAmount = MutableLiveData<Int>()

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
            selectedCategoryAmount.value?.inc()
        else
            selectedCategoryAmount.value?.dec()
    }
}