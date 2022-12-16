package com.fox.dzenallcups.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private val categories = mutableListOf(
        "Юмор", "Еда", "Кино", "Рестораны", "Прогулки",
        "Политика", "Новости", "Автомобили", "Сериалы",
        "Рецепты", "Работа", "Отдых", "Спорт"
    )

    private val categoriesLiveData = MutableLiveData<MutableList<String>>()

    fun observeCategories() = categoriesLiveData

    init {
        Log.d("TAG", "ViewModel init")
        categoriesLiveData.value = categories
    }
}