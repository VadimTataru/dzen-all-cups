package com.fox.dzenallcups.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    val categories = mutableListOf(
        "Юмор", "Еда", "Кино", "Рестораны", "Прогулки",
        "Политика", "Новости", "Автомобили", "Сериалы",
        "Рецепты", "Работа", "Отдых", "Спорт"
    )

    init {
        Log.d("TAG", "ViewModel init")
    }
}