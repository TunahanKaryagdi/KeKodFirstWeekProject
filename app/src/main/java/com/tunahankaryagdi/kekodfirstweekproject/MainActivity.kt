package com.tunahankaryagdi.kekodfirstweekproject

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.tunahankaryagdi.kekodfirstweekproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            val destinationId = when (item.itemId) {
                R.id.homeFragment -> R.id.homeFragment
                R.id.happinessFragment -> R.id.happinessFragment
                R.id.givingFragment -> R.id.givingFragment
                R.id.respectFragment -> R.id.respectFragment
                R.id.kindnessFragment -> R.id.kindnessFragment
                R.id.optimismFragment -> R.id.optimismFragment
                else -> return@setOnItemSelectedListener false
            }

            val currentDestinationId = navController.currentDestination?.id

            if (currentDestinationId != destinationId) {
                navController.navigate(
                    destinationId, null, NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_up)
                        .setExitAnim(R.anim.slide_down)
                        .setPopEnterAnim(R.anim.slide_up)
                        .setPopExitAnim(R.anim.slide_down)
                        .build()
                )
            }
            true
        }


    }

    fun addToBottomBar(menuItem: MenuItem): Boolean {

        val isAdded = viewModel.isAdded(menuItem)

        if (isAdded) return true

        if ((viewModel.addedItems.value?.size ?: 0) >= 5) {
            Toast.makeText(this, getString(R.string.cannot), Toast.LENGTH_LONG).show()
            return false
        }

        binding.bottomNavigationView.menu.add(
            Menu.NONE,
            menuItem.id,
            Menu.NONE,
            getString(menuItem.titleResId)
        ).setIcon(menuItem.iconResId)
        viewModel.addItem(menuItem)
        return true

    }

    fun removeFromBottomBar(menuItem: MenuItem): Boolean {
        val isAdded = viewModel.isAdded(menuItem)

        if (isAdded) {
            binding.bottomNavigationView.menu.removeItem(menuItem.id)
            viewModel.removeItem(menuItem)
            return true
        }
        return false
    }

    fun removeAllFromBottomBar() {
        binding.bottomNavigationView.menu.clear()
        viewModel.clearItems()
    }

    fun setBottomBarVisibility(isVisible: Boolean) {
        binding.bottomNavigationView.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }

}