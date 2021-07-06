package com.carolinac.lifedogapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.carolinac.lifedogapp.data.dao.*
import com.carolinac.lifedogapp.data.entity.*

@Database(
    entities = [AccesoriesExpense::class, Allergy::class, Bath::class, CareExpenses::class,
        Consultation::class, DewormerType::class, Deworming::class, Disease::class, Dog::class, Feeding::class,
        FoodCategory::class, FoodExpense::class, Haircut::class, Medication::class, Medicine::class,
        MedicineCategory::class, MedicineExpense::class, Size::class, Term::class, User::class, UserWithUserXDog::class,
        UserXDog::class, Vaccine::class, VaccineCategory::class, VaccineExpense::class], version = 1
)
abstract class LifeDogDatabase : RoomDatabase() {
    abstract fun activityDao(): ActivityDAO
    abstract fun dewormingDao(): DewormingDAO
    abstract fun dogDao(): DogDAO
    abstract fun foodDao(): FoodDAO
    abstract fun healthDao(): HealthDAO
    abstract fun userDao(): UserDAO
    abstract fun vaccineDao(): VaccineDAO

    companion object {
        @Volatile
        private var INSTANCE: LifeDogDatabase? = null

        fun getDatabase(context: Context): LifeDogDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    LifeDogDatabase::class.java, "LifedogDB"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}