package com.tunahankaryagdi.kekodfirstweekproject

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.tunahankaryagdi.kekodfirstweekproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val addedItems by lazy {
        mutableListOf<MenuItem>()
    }

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

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

    }

    fun addToBottomBar(menuItem: MenuItem,button: CompoundButton) {

        val isAdded = addedItems.contains(menuItem)

        if (addedItems.size >= 5){
            Toast.makeText(this,getString(R.string.cannot),Toast.LENGTH_LONG).show()
            button.isChecked = false
            return
        }

        if (!isAdded){
            binding.bottomNavigationView.menu.add(
                Menu.NONE,
                menuItem.id,
                Menu.NONE,
                getString(menuItem.titleResId)
            ).setIcon(menuItem.iconResId)

            addedItems.add(menuItem)
        }
    }

    fun removeFromBottomBar(menuItem: MenuItem, button: CompoundButton) {
        val isAdded = addedItems.contains(menuItem)

        if (isAdded) {
            binding.bottomNavigationView.menu.removeItem(menuItem.id)
            addedItems.remove(menuItem)
            button.isChecked = false
        }
    }

    fun removeAllFromBottomBar(){
        binding.bottomNavigationView.menu.clear()
        addedItems.clear()
    }

    fun setBottomBarVisibility(isVisible: Boolean){
        binding.bottomNavigationView.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }

}