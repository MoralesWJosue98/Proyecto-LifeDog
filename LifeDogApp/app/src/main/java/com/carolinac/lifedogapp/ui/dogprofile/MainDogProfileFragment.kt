package com.carolinac.lifedogapp.ui.dogprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.carolinac.lifedogapp.LifeDogApplication
import com.carolinac.lifedogapp.R
import com.carolinac.lifedogapp.databinding.FragmentInitialBinding
import com.carolinac.lifedogapp.databinding.FragmentMainDogProfileBinding
import com.carolinac.lifedogapp.ui.initial.InitialViewModel
import com.carolinac.lifedogapp.ui.initial.InitialViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainDogProfileFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var dogDetailsButton: Button
    private lateinit var feedingBtn: LinearLayout
    private lateinit var walksBtn: LinearLayout
    private lateinit var bathsBtn: LinearLayout
    private lateinit var haircutBtn: LinearLayout
    private lateinit var vaccineBtn: LinearLayout
    private lateinit var medicineBtn: LinearLayout
    private lateinit var vetVisitBtn: LinearLayout
    private lateinit var dewormingBtn: LinearLayout

    private val factory by lazy{
        val app = requireActivity().application as LifeDogApplication
        DogProfileViewModelFactory(app.lifeDogRepository)
    }

    private val viewModel : DogProfileViewModel by viewModels {
        factory
    }

    private var _binding: FragmentMainDogProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainDogProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        bind(view)
        setListeners()

        binding.apply {
            viewmodel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        viewModel.advice.observe(viewLifecycleOwner){
            viewModel.updateViewText()
        }

        viewModel.selectedDog.observe(viewLifecycleOwner){ dog ->
            if(dog != null){
                viewModel.updateAdvice()
            }
        }

    }

    private fun bind(view: View) {
        dogDetailsButton = view.findViewById(R.id.dogDetailsButton)
        feedingBtn = view.findViewById(R.id.feedingGradient)
        walksBtn = view.findViewById(R.id.walksGradient)
        bathsBtn = view.findViewById(R.id.bathsGradient)
        haircutBtn = view.findViewById(R.id.haircutGradient)
        vaccineBtn = view.findViewById(R.id.vaccinesGradient)
        medicineBtn = view.findViewById(R.id.medicinesGradient)
        vetVisitBtn = view.findViewById(R.id.vetVisitsGradient)
        dewormingBtn = view.findViewById(R.id.dewormingGradient)
    }

    private fun setListeners() {
        dogDetailsButton.setOnClickListener {
            navController.navigate(R.id.action_mainDogProfileFragment_to_dogDetailsFragment2)
        }
        feedingBtn.setOnClickListener {
            navController.navigate(R.id.action_mainDogProfileFragment_to_feeding)
        }
        walksBtn.setOnClickListener {
            navController.navigate(R.id.action_mainDogProfileFragment_to_dogWalksFragment)
        }
        bathsBtn.setOnClickListener {
            navController.navigate(R.id.action_mainDogProfileFragment_to_toilets)
        }
        haircutBtn.setOnClickListener {
            navController.navigate(R.id.action_mainDogProfileFragment_to_haircutsFragment)
        }
        vaccineBtn.setOnClickListener {
            navController.navigate(R.id.action_mainDogProfileFragment_to_vaccinesFragment)
        }
        vetVisitBtn.setOnClickListener {
            navController.navigate(R.id.action_mainDogProfileFragment_to_vetVisitsFragment)
        }
        medicineBtn.setOnClickListener {
            navController.navigate(R.id.action_mainDogProfileFragment_to_medicinesFragment)
        }
        dewormingBtn.setOnClickListener {
            navController.navigate(R.id.action_mainDogProfileFragment_to_dewormingFragment)
        }
    }

}