package com.carolinac.lifedogapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.carolinac.lifedogapp.R

class DogProfilesFragment : Fragment() {
    private lateinit var addDogButton: ImageButton
    private lateinit var auxButton: Button
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dog_profiles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        bind(view)

        setListeners()
    }

    private fun bind(view: View) {
        addDogButton = view.findViewById(R.id.addDogButton)
        auxButton = view.findViewById(R.id.button2)
    }

    private fun setListeners() {
        addDogButton.setOnClickListener {
            navController.navigate(R.id.action_dogProfilesFragment2_to_addDogFormFragment)
        }
        auxButton.setOnClickListener {
            navController.navigate(R.id.action_dogProfilesFragment2_to_mainDogProfileFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() : DogDetailsFragment = DogDetailsFragment()
    }
}