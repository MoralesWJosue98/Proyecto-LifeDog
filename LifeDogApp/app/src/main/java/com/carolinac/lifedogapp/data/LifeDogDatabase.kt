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
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
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
                            /* DewormerType */
                            getDatabase(context).dewormingDao()
                                .insertOrUpdateDewormerType(PREPOPULATE_DEWTYPE)
                            /* Dog Size */
                            getDatabase(context).dogDao()
                                .insertOrUpdateSize(PREPOPULATE_SIZE)
                            /* Food Category */
                            getDatabase(context).foodDao()
                                .insertOrUpdateFoodCategory(PREPOPULATE_FOODCATEGORY)
                            /* Vaccine Category */
                            getDatabase(context).vaccineDao()
                                .insertOrUpdateVaccineCategory(PREPOPULATE_VACCINECATEGORY)
                            /* Medicine Category*/
                            getDatabase(context).healthDao()
                                .insertOrUpdateMedicineCategory(PREPOPULATE_MEDICINECATEGORY)
                        }
                    }

                    private fun ioThread(function: () -> Unit) {
                        Executors.newSingleThreadExecutor().execute(function)
                    }
                })
                .build()

        val PREPOPULATE_DEWTYPE = listOf(
            DewormerType(1, "Sentry HC WormX Plus "),
            DewormerType(2, " Beaphar"), DewormerType(3, "Triple Wormer Broad Spectrum")
        )

        val PREPOPULATE_SIZE = listOf(
            Size(1, "Pequeño"), Size(2, "Mediano"), Size(3, "Grande")
        )

        val PREPOPULATE_FOODCATEGORY = listOf(
            FoodCategory(1, "Croquetas"), FoodCategory(2, "Galletas"),
            FoodCategory(3, "Concentrado")
        )

        val PREPOPULATE_VACCINECATEGORY = listOf(
            VaccineCategory(1, "Parvovirus", "Vacuna contra virus del Moquillo"),
            VaccineCategory(
                2,
                "Polivalente",
                "Vacuna contra el parvovirus, virus del moquillo, virus de la para influenza, virus de la hepatitis"
            ),
            VaccineCategory(3, "Rabia", "Vacuna contra virus de la Rabia")
        )

        val PREPOPULATE_MEDICINECATEGORY = listOf(
            MedicineCategory(1, "AntiPulgas"),
            MedicineCategory(2, "Rimadyl Anti Inflamatorio"),
            MedicineCategory(3, "Dermil Antihistamínico"),
        )

    }
}