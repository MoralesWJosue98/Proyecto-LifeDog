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
        UserXDog::class, Vaccine::class, VaccineCategory::class, VaccineExpense::class, DogWalk::class,
        Advices::class],
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
                            /* DewormerType */
                            getDatabase(context).dewormingDao()
                                .insertOrUpdateDewormerType(PREPOPULATE_DEWTYPE)
                            /* Dog Size */
                            getDatabase(context).dogDao()
                                .insertOrUpdateSize(PREPOPULATE_SIZE)
                            /* Food Category */
                            getDatabase(context).foodDao()
                                .insertOrUpdateFoodCategory(PREPOPULATE_FOOD_CATEGORY)
                            /* Vaccine Category */
                            getDatabase(context).vaccineDao()
                                .insertOrUpdateVaccineCategory(PREPOPULATE_VACCINE_CATEGORY)
                            /* Medicine Category*/
                            getDatabase(context).healthDao()
                                .insertOrUpdateMedicineCategory(PREPOPULATE_MEDICINE_CATEGORY)
                            /* Consejos para Razas Peque??as */
                            getDatabase(context).dogDao()
                                .insertAdviceSmall(PREPOPULATE_ADVICE_SMALL)
                            /* Consejos para Razas Medianas */
                            getDatabase(context).dogDao()
                                .insertAdviceMedium(PREPOPULATE_ADVICE_MEDIUM)
                            /* Consejos para Razas Grandes */
                            getDatabase(context).dogDao()
                                .insertAdviceBig(PREPOPULATE_ADVICE_BIG)
                        }
                    }

                    private fun ioThread(function: () -> Unit) {
                        Executors.newSingleThreadExecutor().execute(function)
                    }
                })
                .build()

        val PREPOPULATE_DATA = listOf(
            DewormerType(1, "Sentry HC WormX Plus "),
            DewormerType(2, " Beaphar"), DewormerType(3, "Triple Wormer Broad Spectrum"))

        val PREPOPULATE_DEWTYPE = listOf(
            DewormerType(1, "Sentry HC WormX Plus "),
            DewormerType(2, " Beaphar"),
            DewormerType(3, "Triple Wormer Broad Spectrum")
        )

        val PREPOPULATE_SIZE = listOf(
            Size(1, "Peque??o"),
            Size(2, "Mediano"),
            Size(3, "Grande")
        )

        val PREPOPULATE_FOOD_CATEGORY = listOf(
            FoodCategory(1, "Croquetas"),
            FoodCategory(2, "Galletas"),
            FoodCategory(3, "Concentrado")
        )

        val PREPOPULATE_VACCINE_CATEGORY = listOf(
            VaccineCategory(1, "Parvovirus", "Vacuna contra virus del Moquillo"),
            VaccineCategory(
                2,
                "Polivalente",
                "Vacuna contra el parvovirus, virus del moquillo, virus de la para influenza, virus de la hepatitis"
            ),
            VaccineCategory(3, "Rabia", "Vacuna contra virus de la Rabia")
        )

        val PREPOPULATE_MEDICINE_CATEGORY = listOf(
            MedicineCategory(1, "AntiPulgas"),
            MedicineCategory(2, "Rimadyl Anti Inflamatorio"),
            MedicineCategory(3, "Dermil Antihistam??nico"),
        )

        val PREPOPULATE_ADVICE_SMALL = listOf(
            Advices(
                1,
                1,
                "Alim??ntalo seg??n sus necesidades!, el metabolismo de los canes de baja estatura es much??simo m??s acelerado que el resto.",
                "CiudadDeMascotas.com"
            ),
            Advices(
                2,
                1,
                "Cuida sus u??as!, los perros de raza peque??a necesitan que sus u??as sean cortadas con m??s frecuencia, ya que tienen menos posibilidades de desgastarlas naturalmente que sus cong??neres de mayor tama??o.",
                "misanimales.com"
            ),
            Advices(
                3,
                1,
                "Acude peri??dicamente al veterinario!, las v??lvulas del coraz??n pueden ocasionarle problemas a alrededor del 60% de los perros de raza peque??a, haciendo que este ??rgano se debilite y no bombee la suficiente sangre.",
                "purina.com"
            )
        )

        val PREPOPULATE_ADVICE_MEDIUM = listOf(
            Advices(
                4,
                2,
                "Alimentaci??n!, toma en cuenta, que por el tama??o de t?? perro, su alimentaci??n conllevara porciones m??s grandes, alimentalo seg??n su tama??o.",
                "purina.com"
            ),
            Advices(
                5,
                2,
                "Tiempo para su paseo!, t?? perro tendr?? mucha energ??a, debes de programar sus paseos necesarios y los tiempos de juego.",
                "educachorros.com"
            ),
            Advices(
                6,
                2,
                "Ba??alo!, t?? perro requiere de ba??os m??nimo quincenales, cepillalo muy bien y ten en cuenta los cuidados b??sicos para una buena higiene.",
                "adiestramientocanino.com"
            )
        )

        val PREPOPULATE_ADVICE_BIG = listOf(
            Advices(
                7,
                3,
                "Espacio!, t?? perro necesita tener el espacio suficiente como para estar c??modo, y sentirse feliz",
                "kiwoko.com"
            ),
            Advices(
                8,
                3,
                "Socializa!, t?? perro tiene que socializar con otros perros y humanos para que se siente c??modo frente a situaciones que representen mucho estr??s.",
                "misanimales.com"
            ),
            Advices(
                9,
                3,
                "Acude al Veterinario!, los perros de razas grandes son propensos a ciertos problemas de salud, sobre todo relacionados a las articulaciones",
                "purina.com"
            )
        )
    }
}