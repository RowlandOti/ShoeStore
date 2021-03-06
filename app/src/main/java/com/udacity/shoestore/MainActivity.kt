package com.udacity.shoestore

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.ui.login.LoginViewModel
import com.udacity.shoestore.ui.login.LoginViewModel.AuthenticationState
import com.udacity.shoestore.ui.login.LoginViewModel.AuthenticationState.AUTHENTICATED
import com.udacity.shoestore.ui.login.LoginViewModelFactory
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())

        loginViewModel = ViewModelProviders.of(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.loginFragment, R.id.shoeListFragment))

        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        loginViewModel.authenticationState.observe(this, Observer { authenticationState ->
            when (authenticationState) {
                AuthenticationState.UNAUTHENTICATED -> {
                    navController.navigate(R.id.loginFragment, null,
                        navOptions {
                            popUpTo = R.id.authenticatedAreaGraph
                            launchSingleTop = true
                        })

                }
                AUTHENTICATED -> {

                }
                else -> {
                }
            }
        })

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in arrayOf(
                    R.id.loginFragment,
                    R.id.onboardingFragment,
                    R.id.instructionFragment
                )
            ) {
                binding.toolbar.visibility = View.GONE
            } else {
                binding.toolbar.visibility = View.VISIBLE
            }

        }
    }

        override fun onSupportNavigateUp(): Boolean {
            val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
            return navController.navigateUp() || super.onSupportNavigateUp()
        }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            val inflater = menuInflater
            inflater.inflate(R.menu.menu_activity_main, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.logout -> {
                    loginViewModel.logout()
                    true
                }

                else -> super.onOptionsItemSelected(item)
            }
        }
    }
