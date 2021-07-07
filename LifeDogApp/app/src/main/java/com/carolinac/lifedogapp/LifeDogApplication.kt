package com.carolinac.lifedogapp

import android.app.Application
import com.carolinac.lifedogapp.data.LifeDogDatabase
import com.carolinac.lifedogapp.network.API
import com.carolinac.lifedogapp.repository.LifeDogRepository

class LifeDogApplication : Application() {
    private val database by lazy {
        LifeDogDatabase.getDatabase(this)
    }
    val lifeDogRepository by lazy {
        val activityDao = database.activityDao()
        val dewormingDao = database.dewormingDao()
        val dogDao = database.dogDao()
        val expenseDao = database.expenseDao()
        val foodDao = database.foodDao()
        val healthDao = database.healthDao()
        val userDao = database.userDao()
        val vaccineDao = database.vaccineDao()
        LifeDogRepository(
            activityDao,
            dewormingDao,
            dogDao,
            expenseDao,
            foodDao,
            healthDao,
            userDao,
            vaccineDao,
            API
        )
    }
}