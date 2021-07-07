package com.carolinac.lifedogapp.ui.expensesfood

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carolinac.lifedogapp.data.entity.FoodExpense
import com.carolinac.lifedogapp.repository.LifeDogRepository

class ExpensesFoodViewModel(private val repository: LifeDogRepository): ViewModel() {
    val cantidad = MutableLiveData("")
    val precio = MutableLiveData("")
    val categories = repository.findAllFoodCategory()

    val message = MutableLiveData<String>()

    fun addExpense(){

    }

}