package com.carolinac.lifedogapp.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.carolinac.lifedogapp.repository.LifeDogRepository
import com.carolinac.lifedogapp.ui.login.LoginViewModel
import java.lang.Exception

class SettingsViewModelFactory(private val repository: LifeDogRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            return SettingsViewModel(repository) as T
        }
        throw Exception("Unknown ViewModel Class")
    }
}