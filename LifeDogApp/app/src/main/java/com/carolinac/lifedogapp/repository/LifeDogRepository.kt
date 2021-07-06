package com.carolinac.lifedogapp.repository

import androidx.lifecycle.LiveData
import com.carolinac.lifedogapp.data.dao.*
import com.carolinac.lifedogapp.data.entity.*

class LifeDogRepository(
    private val activityDao: ActivityDAO,
    private val dewormingDao: DewormingDAO,
    private val dogDao: DogDAO,
    private val expenseDao: ExpenseDAO,
    private val foodDao: FoodDAO,
    private val healthDao: HealthDAO,
    private val userDao: UserDAO,
    private val vaccineDao: VaccineDAO
) {
    /* ActivityDAO*/
    suspend fun insertHaircut(haircut: Haircut) = activityDao.insertOrUpdateDogHaircut(haircut)
    suspend fun insertConsultation(consultation: Consultation) =
        activityDao.insertOrUpdateDogConsultation(consultation)

    fun findAllDogHaircut(): LiveData<List<DogWithHaircut>> = activityDao.getDogHaircut()
    fun findAllDogConsultation(): LiveData<List<DogWithConsultation>> =
        activityDao.getDogConsultation()

    /* DewormingDAO */
    /*TODO: suspend fun insertDewormerType*/
    suspend fun insertDeworming(deworming: Deworming) =
        dewormingDao.insertOrUpdateDeworming(deworming)

    fun findAllDewormerType(): LiveData<List<DewormerType>> = dewormingDao.getDewormerType()
    fun findAllDogDeworming(): LiveData<List<DogWithDeworming>> = dewormingDao.getDogWithDeworming()

    /* DogDAO */
    /*TODO: suspend fun insertSize*/
    suspend fun insertBath(bath: Bath) = dogDao.insertBath(bath)
    suspend fun insertDog(dog: Dog) = dogDao.insertOrUpdateDog(dog)
    suspend fun insertDogWalk(dogWalk: DogWalk) = dogDao.insertOrUpdateDogWalk(dogWalk)
    suspend fun insertAllergy(allergy: Allergy) = dogDao.insertOrUpdateDogAllergy(allergy)
    suspend fun insertDisease(disease: Disease) = dogDao.insertOrUpdateDogDisease(disease)
    suspend fun insertMedication(medication: Medication) =
        dogDao.insertOrUpdateDogMedication(medication)

    fun findDogInfo(dogId: Int) = dogDao.getDogInfo(dogId)
    fun findSize(): LiveData<List<Size>> = dogDao.getSize()
    fun findAllDogBath(): LiveData<List<DogWithBath>> = dogDao.getDogBath()
    fun findAllDogWalk(): LiveData<List<DogWithDogWalk>> = dogDao.getDogWalk()
    fun findAllUserDog(): LiveData<List<DogWithUserXDog>> = dogDao.getDogUser()
    fun findAllDogAllergy(): LiveData<List<DogWithAllergy>> = dogDao.getDogAllergy()
    fun findAllDogDisease(): LiveData<List<DogWithDiseases>> = dogDao.getDogDiseases()
    fun findAllDogMedication(): LiveData<List<DogWithMedication>> = dogDao.getDogMedication()

    /* ExpenseDAO */
    suspend fun insertMedicineExpense(medicineExpense: MedicineExpense) =
        expenseDao.insertOrReplaceMedicineExpense(medicineExpense)

    suspend fun accesorieExpense(accesoriesExpense: AccesoriesExpense) =
        expenseDao.insertOrReplaceAccesoriesExpense(accesoriesExpense)

    suspend fun careExpense(careExpenses: CareExpenses) =
        expenseDao.insertOrReplaceCareExpense(careExpenses)

    fun findAllDogMedicineExpense(): LiveData<List<DogWithMedicineExpense>> =
        expenseDao.getMedicineExpense()

    fun findAllDogAccesoriesExpense(): LiveData<List<DogAndAccesoriesExpense>> =
        expenseDao.getAccesoriesExpense()

    fun findAllDogCareExpense(): LiveData<List<DogWithCareExpenses>> = expenseDao.getCareExpense()

    /* FoodDAO */
    /*TODO: suspend fun insertFoodCategory*/
    suspend fun insertFoodExpense(foodExpense: FoodExpense) =
        foodDao.insertOrUpdateFoodExpense(foodExpense)

    suspend fun insertFeeding(feeding: Feeding) = foodDao.insertOrIgnoreFeeding(feeding)
    fun findAllFoodCategory(): LiveData<List<FoodCategory>> = foodDao.getFoodCategory()
    fun findAllDogFoodExpense(): LiveData<List<DogWithFoodExpense>> = foodDao.getFoodExpense()

    /* HealthDAO */
    /*TODO: suspend fun insertMedicineCategory*/
    suspend fun insertTerm(term: Term) = healthDao.insertOrUpdateTerm(term)
    suspend fun insertMedicine(medicine: Medicine) = healthDao.insertOrUpdateMedicine(medicine)
    fun findAllMedicineCategory(): LiveData<List<MedicineCategory>> =
        healthDao.getMedicineCategory()

    /* UserDAO */
    suspend fun insertUser(user: User) = userDao.insertOrUpdateUser(user)
    fun findAllDogUser(): LiveData<List<UserWithUserXDog>> = userDao.getUserDog()

    /* VaccineDAO */
    /*TODO: suspend fun insertVaccineCategory*/
    suspend fun insertVaccineExpense(vaccineExpense: VaccineExpense) =
        vaccineDao.insertOrUpdateVaccineExpense(vaccineExpense)

    suspend fun insertVaccine(vaccine: Vaccine) = vaccineDao.insertOrUpdateVaccine(vaccine)
    fun findAllVaccineCategory(): LiveData<List<VaccineCategory>> = vaccineDao.getVaccineCategory()
    fun findAllDogVaccineExpense(): LiveData<List<DogWithVaccineExpense>> =
        vaccineDao.getDogWithVaccineExpense()

    fun findAllDogVaccine(): LiveData<List<DogWithVaccine>> = vaccineDao.getDogWithVaccine()

}