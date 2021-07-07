package com.carolinac.lifedogapp.data

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.carolinac.lifedogapp.data.dao.*
import com.carolinac.lifedogapp.data.entity.*
import java.util.concurrent.Executors

@Database(
    entities = [AccesoriesExpense::class, Allergy::class, Bath::class, CareExpenses::class,
        Consultation::class, DewormerType::class, Deworming::class, Disease::class, Dog::class, Feeding::class,
        FoodCategory::class, FoodExpense::class, Haircut::class, Medication::class, Medicine::class,
        MedicineCategory::class, MedicineExpense::class, Size::class, Term::class, User::class,
        UserXDog::class, Vaccine::class, VaccineCategory::class, VaccineExpense::class, DogWalk::class],
    version = 1
)
@TypeConverters(Converters::class, PriceConverters::class)
abstract class LifeDogDatabase : RoomDatabase() {
    abstract fun activityDao(): ActivityDAO
    abstract fun dewormingDao(): DewormingDAO
    abstract fun dogDao(): DogDAO
    abstract fun expenseDao(): ExpenseDAO
    abstract fun foodDao(): FoodDAO
    abstract fun healthDao(): HealthDAO
    abstract fun userDao(): UserDAO
    abstract fun vaccineDao(): VaccineDAO

    companion object {
        @Volatile
        private var INSTANCE: LifeDogDatabase? = null

        fun getDatabase(context: Context): LifeDogDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = buildDatabase(context)
                INSTANCE = instance
                instance
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                LifeDogDatabase::class.java, "LifedogDB"
            )
                // prepopulate the database after onCreate was called
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // insert the data on the IO Thread
                        ioThread {
                            getDatabase(context).dewormingDao()
                                .insertOrUpdateDewormerType(PREPOPULATE_DATA)
                        }
                    }

                    private fun ioThread(function: () -> Unit) {
                        Executors.newSingleThreadExecutor().execute(function)
                    }
                })
                .build()

        val PREPOPULATE_DATA = listOf(
            DewormerType(1, "Sentry HC WormX Plus "),
            DewormerType(2, " Beaphar"), DewormerType(3, "Triple Wormer Broad Spectrum")
        )
    }
}