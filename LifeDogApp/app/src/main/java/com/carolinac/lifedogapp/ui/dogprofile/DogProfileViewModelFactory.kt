package com.carolinac.lifedogapp.ui.dogprofile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carolinac.lifedogapp.repository.LifeDogRepository
import com.carolinac.lifedogapp.ui.expensescosts.ExpensesCostViewModel
import java.lang.Exception

class DogProfileViewModelFactory(private val repository: LifeDogRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DogProfileViewModel::class.java)) {
            return DogProfileViewModel(repository) as T
        }
        throw Exception("Unknown ViewModel Class")
    }
}