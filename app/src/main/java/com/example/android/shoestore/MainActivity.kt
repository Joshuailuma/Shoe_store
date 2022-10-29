package com.example.android.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

/**
 * Creates an Activity that hosts all of the fragments in the app
 */
class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        // FInd nav controller
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val navController = navHostFragment!!.findNavController()

        // Hookup nav UI with action bar
        NavigationUI.setupActionBarWithNavController(this, navController)
        //Hook up drawer with UI
        appBarConfiguration = AppBarConfiguration(navController.graph)
    }

    // Handle what happens when up button is pressed
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}
