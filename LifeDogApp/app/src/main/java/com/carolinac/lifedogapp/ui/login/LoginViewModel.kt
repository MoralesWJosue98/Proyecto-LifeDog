package com.carolinac.lifedogapp.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolinac.lifedogapp.R
import com.carolinac.lifedogapp.data.entity.User
import com.carolinac.lifedogapp.repository.LifeDogRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel(private val repository: LifeDogRepository) : ViewModel() {
    private var user : User? = null

    val email = MutableLiveData("")
    val password = MutableLiveData("")
    val error = MutableLiveData<Int?>()

    fun login(){
        viewModelScope.launch {
            try {
                if(!email.value.isNullOrEmpty() && !password.value.isNullOrEmpty()){
                    user = User(0,"",password.value!!,null,email.value!!,false)
                    user = repository.loginUser(user!!)
                    repository.insertUser(user!!)
                    error.value = R.string.welcome
                }else{
                    error.value = R.string.emptyfields
                }
            }
            catch (e : HttpException){
                error.value = R.string.login_error
            }
        }
    }

    fun userIsLogged(): Boolean? {
        return user?.logged
    }

    fun probandoAndo(){
        viewModelScope.launch {
            var user = User(0, "wil es gei", "wil es gei", null, "wil@es.gei", false)
            repository.insertUser(user)
        }
    }
}