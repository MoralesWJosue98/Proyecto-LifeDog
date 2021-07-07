package com.carolinac.lifedogapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.carolinac.lifedogapp.R
import kotlin.math.sign

class LoginFragment : Fragment() {
    private lateinit var loginButton: Button
    private lateinit var signUpButton: Button
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        bind(view)
        setListeners()
    }

    private fun bind(view: View) {
        loginButton = view.findViewById(R.id.loginButton)
        signUpButton = view.findViewById(R.id.signUpButton)
    }

    private fun setListeners() {
        loginButton.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_homeProfilesNavContainer)
        }
        signUpButton.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signUpFormFragment)
        }
    }
}