package com.carolinac.lifedogapp.ui.settings

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolinac.lifedogapp.R
import com.carolinac.lifedogapp.data.entity.User
import com.carolinac.lifedogapp.repository.LifeDogRepository
import kotlinx.coroutines.launch

class SettingsViewModel(private val repository: LifeDogRepository): ViewModel() {
    val username = MutableLiveData("")
    val email = MutableLiveData("")
    val message = MutableLiveData<Int>()

    val user = repository.getLoggedUser()

    fun changeText(){
        username.value = user.value!!.username
        email.value = user.value!!.email
    }

    fun logOut(){
        viewModelScope.launch {
            user.value!!.logged = false
            repository.logOut(user.value!!)
            message.value = R.string.succesfullyLogOut
        }
    }

}