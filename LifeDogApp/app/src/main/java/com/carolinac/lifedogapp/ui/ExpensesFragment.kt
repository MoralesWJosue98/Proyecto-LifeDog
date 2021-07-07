package com.carolinac.lifedogapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.carolinac.lifedogapp.R

class ExpensesFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var expensesFoodBtn: LinearLayout
    private lateinit var expensesAccesoriesBtn: LinearLayout
    private lateinit var expensesMedicinesBtn: LinearLayout
    private lateinit var expensesCareBtn: LinearLayout
    private lateinit var expensesVaccinesBtn: LinearLayout
    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expenses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        bind(view)
        fillSpinner(view)

        setListeners()
    }

    private fun bind(view: View) {
        expensesFoodBtn = view.findViewById(R.id.expensesFoodBtn)
        expensesAccesoriesBtn = view.findViewById(R.id.expensesAccesoriesBtn)
        expensesMedicinesBtn = view.findViewById(R.id.expensesMedicinesBtn)
        expensesCareBtn = view.findViewById(R.id.expensesCareBtn)
        expensesVaccinesBtn = view.findViewById(R.id.expensesVaccinesBtn)
    }

    private fun setListeners() {
        expensesFoodBtn.setOnClickListener {
            navController.navigate(R.id.action_expensesFragment_to_expensesFood)
        }
        expensesAccesoriesBtn.setOnClickListener {
            navController.navigate(R.id.action_expensesFragment_to_expensesCosts)
        }
        expensesMedicinesBtn.setOnClickListener {
            navController.navigate(R.id.action_expensesFragment_to_expensesMedicine2)
        }
        expensesCareBtn.setOnClickListener {
            navController.navigate(R.id.action_expensesFragment_to_expensesCareful2)
        }
        expensesVaccinesBtn.setOnClickListener {
            navController.navigate(R.id.action_expensesFragment_to_expensesVaccines)
        }
    }

    private fun fillSpinner(view : View){
        spinner = view.findViewById<Spinner>(R.id.statistics_time_spinner)

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.time_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

}