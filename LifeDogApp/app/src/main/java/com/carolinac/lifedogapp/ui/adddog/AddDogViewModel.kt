package com.carolinac.lifedogapp.ui.adddog

import android.icu.text.SimpleDateFormat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolinac.lifedogapp.R
import com.carolinac.lifedogapp.data.entity.Allergy
import com.carolinac.lifedogapp.data.entity.Disease
import com.carolinac.lifedogapp.data.entity.Dog
import com.carolinac.lifedogapp.repository.LifeDogRepository
import kotlinx.coroutines.launch

class AddDogViewModel(private val repository: LifeDogRepository) : ViewModel() {
    val dogName = MutableLiveData("")
    val breed = MutableLiveData("")
    val isMale = MutableLiveData(true)
    val weight = MutableLiveData("")
    val birthday = MutableLiveData("")
    val color = MutableLiveData("")
    val sterilized = MutableLiveData(false)
    val rage = MutableLiveData("")
    val allergy = MutableLiveData("")
    val rages = MutableLiveData("")
    val allergies = MutableLiveData("")

    val size = MutableLiveData("")
    val sizeId = MutableLiveData<Int>()
    val sizes = repository.findSize()

    val message = MutableLiveData<Int>()
    val dogId = repository.findLastDogId()
    private val allergiesList = mutableListOf<Allergy>()
    private val ragesList = mutableListOf<Disease>()


    fun createDog(){
        viewModelScope.launch {
            if(inputsAreNotEmpty()){
                val date = SimpleDateFormat("dd/MM/yyyy").parse(birthday.value!!)

                val dog = Dog(0,dogName.value!!, breed.value!!, !isMale.value!!,
                    weight.value!!.toFloat(), color.value!!, date,sterilized.value!!,sizeId.value!!.toInt(),false)

                repository.insertDog(dog)
                allergiesList.forEach { a ->
                    repository.insertAllergy(a)
                }

                ragesList.forEach { d ->
                    repository.insertDisease(d)
                }

                message.value = R.string.DogSuccesfullyAdded
            }
            else{
                message.value = R.string.emptyfields
            }
        }
    }

    fun addAllergy(){
        if(!allergy.value.isNullOrBlank()){
            val currentAllergy = Allergy(0, allergy.value!!, dogId.value?:0 + 1)
            allergies.value += " " + currentAllergy.allergy
            allergiesList.add(currentAllergy)
        }
        else{
            message.value = R.string.emptyfields
        }
    }

    fun addRage(){
        if(!rage.value.isNullOrBlank()){
            val currentRage = Disease(0, rage.value!!, dogId.value?:0 + 1)
            rages.value += " " + currentRage.disease
            ragesList.add(currentRage)
        }
        else{
            message.value = R.string.emptyfields
        }
    }


    fun setGender(isMaleDog: Boolean){
        isMale.value = isMaleDog
    }

    fun inputsAreNotEmpty(): Boolean{
        val nombre = dogName.value
        val raza =  breed.value
        val tamanio = size.value
        val peso = weight.value
        val cumple = birthday.value
        val colorcito = color.value

        return !nombre.isNullOrEmpty() && !raza.isNullOrEmpty()
                && !tamanio.isNullOrEmpty() && !peso.isNullOrEmpty()
                && !cumple.isNullOrEmpty() && !colorcito.isNullOrEmpty()
    }

}