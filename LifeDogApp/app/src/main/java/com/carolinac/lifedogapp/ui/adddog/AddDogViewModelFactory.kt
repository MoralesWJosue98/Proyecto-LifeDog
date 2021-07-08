package com.carolinac.lifedogapp.ui.adddog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carolinac.lifedogapp.repository.LifeDogRepository
import java.lang.Exception

class AddDogViewModelFactory(private val repository: LifeDogRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddDogViewModel::class.java)) {
            return AddDogViewModel(repository) as T
        }
        throw Exception("Unknown ViewModel Class")
    }
}