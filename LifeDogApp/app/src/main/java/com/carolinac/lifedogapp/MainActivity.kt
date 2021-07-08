package com.carolinac.lifedogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.carolinac.lifedogapp.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        val bottomNav = findViewById<BottomNavigationView>(R.id.navigation_menu)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.initialFragment ||
                (destination.id == R.id.loginFragment) ||
                (destination.id == R.id.signUpFormFragment)) {
                bottomNav.visibility = View.GONE
            } else {
                bottomNav.visibility = View.VISIBLE
            }
        }

        bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.HomeProfilesNavContainer -> {
                    val fragment = HomeProfilesNavContainer.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.DogProfileNavContainer -> {
                    val fragment = DogProfileNavContainer.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.calendarFragment -> {
                    val fragment = CalendarFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.expensesNavContainer -> {
                    val fragment = ExpensesNavContainer.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.settingsNavContainer -> {
                    val fragment = SettingsNavContainer.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}