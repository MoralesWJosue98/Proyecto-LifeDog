package com.carolinac.lifedogapp.ui.settings

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.carolinac.lifedogapp.LifeDogApplication
import com.carolinac.lifedogapp.MainActivity
import com.carolinac.lifedogapp.R
import com.carolinac.lifedogapp.databinding.FragmentSettingBinding
import com.carolinac.lifedogapp.ui.login.LoginViewModel
import com.carolinac.lifedogapp.ui.login.LoginViewModelFactory

class SettingFragment : Fragment() {
    lateinit var navController: NavController
    lateinit var logOutButton: ImageButton
    private lateinit var btnDelete: ImageButton
    private lateinit var btnUso: ImageButton
    private lateinit var btnPrivacy: ImageButton

    private val factory by lazy{
        val app = requireActivity().application as LifeDogApplication
        SettingsViewModelFactory(app.lifeDogRepository)
    }

    private val viewModel : SettingsViewModel by viewModels {
        factory
    }

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewmodel = viewModel
            lifecycleOwner = viewLifecycleOwner
        }

        bind(view)
        setListeners()

        viewModel.user.observe(viewLifecycleOwner){
            if(it?.logged == true){
                viewModel.changeText()
            }
        }

        viewModel.message.observe(viewLifecycleOwner){
            val toast = Toast.makeText(activity,getString(it!!),Toast.LENGTH_SHORT)
            toast.show()

            restartApp()
        }
    }

    private fun bind(view: View) {
        navController = view.findNavController()
        logOutButton = view.findViewById(R.id.btnLogOut)
        btnDelete = view.findViewById(R.id.btn_eliminar)
        btnUso = view.findViewById(R.id.btn_uso)
        btnPrivacy = view.findViewById(R.id.btn_privacidad)
    }

    private fun setListeners() {
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

    fun restartApp(){
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
        finishAffinity(activity as Activity)
    }
}