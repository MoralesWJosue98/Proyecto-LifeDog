package com.carolinac.lifedogapp.ui.dogprofile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carolinac.lifedogapp.repository.LifeDogRepository
import kotlin.random.Random

class DogProfileViewModel(private val repository: LifeDogRepository): ViewModel() {
    val selectedDog = repository.getSelectedDog()
    private var maxId = 0
    private var minId = 0

    val adviceText = MutableLiveData("")
    var advice = repository.randomAdvice(randomId())

    fun randomId(): Int{
        val sizeId = selectedDog.value?.sizeId
        if(sizeId == 0){
            return Random.nextInt(1, 10)
        }

        maxId = when(sizeId){
            1 ->  3
            2 -> 6
            else -> 9
        }

        minId = maxId - 3

        return Random.nextInt(minId, maxId + 1)
    }

    fun updateAdvice() = repository.randomAdvice(randomId())

    fun updateViewText(){
        val text = advice.value!!.advice + "\n\n" + advice.value!!.source
        adviceText.value = text
    }
}