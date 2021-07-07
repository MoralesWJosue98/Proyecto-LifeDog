package com.carolinac.lifedogapp.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolinac.lifedogapp.R
import com.carolinac.lifedogapp.data.entity.User
import com.carolinac.lifedogapp.repository.LifeDogRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LifeDogRepository) : ViewModel() {
    private lateinit var user : User

    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val error = MutableLiveData<Int?>()

    fun login(){
        viewModelScope.launch {
            if(!email.value.isNullOrEmpty() && !password.value.isNullOrEmpty()){
                user = User(0,"", password.value!!,null, email.value!!, false)
                val isUser = repository.loginUser(user)
                if(isUser){
                    user.logged = true
                    repository.insertUser(user)
                    error.value = R.string.welcome
                }
                else{
                    error.value = R.string.wronginputs
                }
            }else{
                error.value = R.string.emptyfields
            }
        }
    }

    fun userIsLogged(): Boolean{
        return user.logged
    }
}