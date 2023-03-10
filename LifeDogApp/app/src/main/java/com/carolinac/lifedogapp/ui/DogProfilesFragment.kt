package com.carolinac.lifedogapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.carolinac.lifedogapp.R

class DogProfilesFragment : Fragment() {
    private lateinit var addDogButton: ImageButton
    private lateinit var profileCard: LinearLayout
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
        profileCard= view.findViewById(R.id.idProfileCard)
    }

    private fun setListeners() {
        addDogButton.setOnClickListener {
            navController.navigate(R.id.action_dogProfilesFragment2_to_addDogFormFragment)
        }
        profileCard.setOnClickListener {
            navController.navigate(R.id.action_dogProfilesFragment_to_dogProfileNavContainer)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() : DogDetailsFragment = DogDetailsFragment()
    }
}