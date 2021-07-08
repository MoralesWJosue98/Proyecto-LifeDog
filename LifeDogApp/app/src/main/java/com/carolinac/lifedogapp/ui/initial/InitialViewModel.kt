package com.carolinac.lifedogapp.ui.initial

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carolinac.lifedogapp.repository.LifeDogRepository
import kotlin.random.Random

class InitialViewModel(private val repository: LifeDogRepository): ViewModel() {
    val advice = repository.randomAdvice(randomAdviceId())

    val userLogged = repository.getLoggedUser()
    val text = MutableLiveData("")


    fun formText(){
        text.value = advice.value!!.advice + "\n" + advice.value!!.source
    }

    fun randomAdviceId() = Random.nextInt(1,10)


}