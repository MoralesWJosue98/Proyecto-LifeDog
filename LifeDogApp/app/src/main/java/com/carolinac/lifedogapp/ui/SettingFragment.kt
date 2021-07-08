package com.carolinac.lifedogapp.ui

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.carolinac.lifedogapp.R

class SettingFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var btnChangePassword: ImageButton
    private lateinit var btnDelete: ImageButton
    private lateinit var btnUso: ImageButton
    private lateinit var btnPrivacy: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = view.findNavController()
        bind(view)

        setListeners()
    }

    private fun bind(view: View) {
        btnChangePassword = view.findViewById(R.id.btn_cambioContra)
        btnDelete = view.findViewById(R.id.btn_eliminar)
        btnUso = view.findViewById(R.id.btn_uso)
        btnPrivacy = view.findViewById(R.id.btn_privacidad)
    }

    private fun setListeners() {
        btnChangePassword.setOnClickListener {
            navController.navigate(R.id.action_settingFragment_to_changePasswordFragment)
        }
        btnDelete.setOnClickListener {
            navController.navigate(R.id.action_settingFragment_to_deleteAccountFragment)
        }
        btnUso.setOnClickListener {
            navController.navigate(R.id.action_settingFragment_to_termsOfUse)
        }
        btnPrivacy.setOnClickListener {
            navController.navigate(R.id.action_settingFragment_to_privacyPolicy2)
        }
    }
}