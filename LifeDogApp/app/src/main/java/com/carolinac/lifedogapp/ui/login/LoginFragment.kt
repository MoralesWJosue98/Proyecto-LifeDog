package com.carolinac.lifedogapp.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.carolinac.lifedogapp.LifeDogApplication
import com.carolinac.lifedogapp.R
import com.carolinac.lifedogapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var navController: NavController
    lateinit var signUpButton: Button

    private val factory by lazy{
        val app = requireActivity().application as LifeDogApplication
        LoginViewModelFactory(app.lifeDogRepository)
    }

    private val viewModel : LoginViewModel by viewModels {
        factory
    }

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewmodel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        signUpButton = view.findViewById(R.id.signUpButton)
        navController = view.findNavController()

        signUpButton.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signUpFormFragment)
        }

        viewModel.error.observe(viewLifecycleOwner){ messageID ->
            val toast = Toast.makeText(activity, getString(messageID!!), Toast.LENGTH_SHORT)
            toast.show()

            if(viewModel.userIsLogged() == true){
                navController.navigate(R.id.action_loginFragment_to_homeProfilesNavContainer)
            }
        }
    }
}