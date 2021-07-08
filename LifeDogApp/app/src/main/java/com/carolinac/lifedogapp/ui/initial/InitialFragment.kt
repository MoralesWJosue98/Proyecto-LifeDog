package com.carolinac.lifedogapp.ui.initial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.carolinac.lifedogapp.LifeDogApplication
import com.carolinac.lifedogapp.R
import com.carolinac.lifedogapp.databinding.FragmentInitialBinding
import com.carolinac.lifedogapp.databinding.FragmentLoginBinding
import com.carolinac.lifedogapp.ui.login.LoginViewModel
import com.carolinac.lifedogapp.ui.login.LoginViewModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class InitialFragment : Fragment() {
    private lateinit var navController: NavController

    private val factory by lazy{
        val app = requireActivity().application as LifeDogApplication
        InitialViewModelFactory(app.lifeDogRepository)
    }

    private val viewModel : InitialViewModel by viewModels {
        factory
    }

    private var _binding: FragmentInitialBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInitialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()

        binding.apply {
            viewmodel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        view.setOnClickListener {
            navController.navigate(R.id.action_initialFragment_to_loginFragment)
        }

        viewModel.userLogged.observe(viewLifecycleOwner){ user ->
            if(user == null){
                navController.navigate(R.id.action_initialFragment_to_loginFragment)
            }
            else{
                navController.navigate(R.id.action_initialFragment_to_homeProfilesNavContainer)
            }
        }

        viewModel.advice.observe(viewLifecycleOwner){
            viewModel.formText()
            runBlocking {
                delay(1000)
            }
        }

    }
}