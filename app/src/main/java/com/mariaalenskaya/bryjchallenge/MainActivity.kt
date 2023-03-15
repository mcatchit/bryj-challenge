package com.mariaalenskaya.bryjchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.mariaalenskaya.bryjchallenge.databinding.MainActivityBinding
import com.mariaalenskaya.bryjchallenge.ui.MenuAwareFragment

/**
 * Root application activity.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.header)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        binding.navView.setupWithNavController(navController)

        binding.burgerMenu.setOnClickListener {
            notifyFragmentMenuClicked()
        }
    }

    private fun notifyFragmentMenuClicked() {
        val currentFragment =
            supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment_activity_main)
                ?.childFragmentManager?.fragments?.get(0)

        if (currentFragment is MenuAwareFragment) {
            currentFragment.menuClicked()
        }
    }
}
