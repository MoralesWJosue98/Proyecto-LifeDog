package com.carolinac.lifedogapp.ui.expensescosts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carolinac.lifedogapp.repository.LifeDogRepository
import com.carolinac.lifedogapp.ui.login.LoginViewModel
import java.lang.Exception

class ExpensesCostViewModelFactory(private val repository: LifeDogRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ExpensesCostViewModel::class.java)) {
            return ExpensesCostViewModel(repository) as T
        }
        throw Exception("Unknown ViewModel Class")
    }
}