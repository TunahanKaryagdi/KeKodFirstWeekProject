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

        setUiListeners()
    }


    private fun setUiListeners() {

        with(binding) {
            swtEgo.setOnCheckedChangeListener { a, isChecked ->
                if (isChecked) {
                    swtHappiness.isEnabled = false
                    swtOptimism.isEnabled = false
                    swtKindness.isEnabled = false
                    swtGiving.isEnabled = false
                    swtRespect.isEnabled = false
                } else {
                    swtHappiness.isEnabled = true
                    swtOptimism.isEnabled = true
                    swtKindness.isEnabled = true
                    swtGiving.isEnabled = true
                    swtRespect.isEnabled = true
                    bottomNavigationView.visibility = View.VISIBLE
                    addToBottomBar(MenuItem.HOME,a)
                }
            }
            swtHappiness.setOnCheckedChangeListener { a, isChecked ->
                if (isChecked) addToBottomBar(MenuItem.HAPPINESS,a)
            }
            swtOptimism.setOnCheckedChangeListener { a, isChecked ->
                if (isChecked) addToBottomBar(MenuItem.OPTIMISM,a)
            }
            swtKindness.setOnCheckedChangeListener { a, isChecked ->
                if (isChecked) addToBottomBar(MenuItem.KINDESS,a)
            }
            swtGiving.setOnCheckedChangeListener { a, isChecked ->
                if (isChecked) addToBottomBar(MenuItem.GIVING,a)
            }
            swtRespect.setOnCheckedChangeListener { a, isChecked ->
                if (isChecked) addToBottomBar(MenuItem.RESPECT,a)
            }
        }
    }


    private fun addToBottomBar(menuItem: MenuItem,button: CompoundButton) {

        val isAdded = addedItems.contains(menuItem)

        if (addedItems.size >= 5){
            Toast.makeText(this,"Cannot",Toast.LENGTH_LONG).show()
            button.isChecked = false
            return
        }


        if (!isAdded){
            binding.bottomNavigationView.menu.add(
                Menu.NONE,
                menuItem.id,
                Menu.NONE,
                getString(menuItem.titleResId)
            )
                .setIcon(menuItem.iconResId)

            addedItems.add(menuItem)
        }



    }


}