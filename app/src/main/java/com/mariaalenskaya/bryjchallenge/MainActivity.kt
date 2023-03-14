package com.mariaalenskaya.bryjchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.mariaalenskaya.bryjchallenge.databinding.MainActivityBinding
import com.mariaalenskaya.bryjchallenge.ui.MenuAwareFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.header)

        val navView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)

        binding.burgerMenu.setOnClickListener {
            notifyFragment()
        }
    }

    private fun notifyFragment() {
        val currentFragment =
            supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment_activity_main)
                ?.childFragmentManager?.fragments?.get(0)

        if (currentFragment is MenuAwareFragment) {
            currentFragment.menuClicked()
        }
    }
}
