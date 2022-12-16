package com.fox.dzenallcups.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fox.dzenallcups.data.MockCategories
import com.fox.dzenallcups.data.model.Category

class MainActivityViewModel: ViewModel() {

    private val categoriesLiveData = MutableLiveData<MutableList<Category>>()

    fun observeCategories() = categoriesLiveData

    init {
        Log.d("TAG", "ViewModel init")
        categoriesLiveData.value = MockCategories.categories
    }

    fun setCheckedState(category: Category){
        category.checked = !category.checked
    }
}