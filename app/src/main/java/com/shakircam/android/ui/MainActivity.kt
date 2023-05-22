package com.shakircam.android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.shakircam.android.R
import com.shakircam.android.databinding.ActivityMainBinding
import com.shakircam.android.work.TestWorker
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initWorkManager()
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        //bottom nav
        binding.bottomNavigationView.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.repositoryFragment,
                R.id.commitFragment,
            )
        )

        // connect appbar with nav controller
        setupActionBarWithNavController(navController, appBarConfiguration)

        //hide bottom navigation in specific fragment
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {

                R.id.repositoryDetailsFragment ->
                    binding.bottomNavigationView.visibility = View.GONE

                else ->
                    binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }

    private fun initWorkManager() {
        val request: WorkRequest = OneTimeWorkRequestBuilder<TestWorker>()
            .build()
        val workManager = WorkManager.getInstance(this)
        workManager.enqueue(request)
    }

    // toolbar back btn pressed
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navHostFragment).navigateUp(appBarConfiguration)
    }

}