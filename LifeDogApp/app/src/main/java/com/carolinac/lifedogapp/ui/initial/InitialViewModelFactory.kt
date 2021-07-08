package com.carolinac.lifedogapp.ui.initial

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carolinac.lifedogapp.repository.LifeDogRepository
import com.carolinac.lifedogapp.ui.login.LoginViewModel
import java.lang.Exception

class InitialViewModelFactory(private val repository: LifeDogRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(InitialViewModel::class.java)) {
            return InitialViewModel(repository) as T
        }
        throw Exception("Unknown ViewModel Class")
    }
}