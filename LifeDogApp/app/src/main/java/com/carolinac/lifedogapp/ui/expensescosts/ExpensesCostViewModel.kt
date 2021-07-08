package com.carolinac.lifedogapp.ui.expensescosts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolinac.lifedogapp.R
import com.carolinac.lifedogapp.data.entity.AccesoriesExpense
import com.carolinac.lifedogapp.data.entity.DogAndAccesoriesExpense
import com.carolinac.lifedogapp.repository.LifeDogRepository
import kotlinx.coroutines.launch

class ExpensesCostViewModel(private val repository: LifeDogRepository): ViewModel() {
    val accesoryText = MutableLiveData("")
    val quantityText = MutableLiveData("")
    val priceText = MutableLiveData("")
    val message = MutableLiveData<Int>()


    //private var dogId = repository.getSelectedDogId()
    private var history = repository.findAllDogAccesoriesExpense()

    fun addExpense(){
        viewModelScope.launch {
            if(accesoryText.value.isNullOrEmpty() || quantityText.value.isNullOrEmpty() || priceText.value.isNullOrEmpty()){
                message.value = R.string.emptyfields
            }else{
                //val expense = AccesoriesExpense(0, accesoryText.value!!, priceText.value!!.toBigDecimal(), quantityText.value!!.toInt(), dogId.value!!)
                //repository.accesorieExpense(expense)
                //message.value = R.string.expense_succesfully_added
            }
        }
    }

}