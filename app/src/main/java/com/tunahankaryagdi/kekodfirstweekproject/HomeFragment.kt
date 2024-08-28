package com.tunahankaryagdi.kekodfirstweekproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import com.tunahankaryagdi.kekodfirstweekproject.databinding.FragmentHappinessBinding
import com.tunahankaryagdi.kekodfirstweekproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
                    setVisibility(false)
                    removeAllFromBottomBar()

                } else {
                    swtHappiness.isEnabled = true
                    swtOptimism.isEnabled = true
                    swtKindness.isEnabled = true
                    swtGiving.isEnabled = true
                    swtRespect.isEnabled = true
                    setVisibility(true)
                    addToBottomBar(MenuItem.HOME,a)
                }
            }
            swtHappiness.setOnCheckedChangeListener { a, isChecked ->
                if (isChecked) addToBottomBar(MenuItem.HAPPINESS,a) else removeFromBottomBar(MenuItem.HAPPINESS,a)
            }
            swtOptimism.setOnCheckedChangeListener { a, isChecked ->
                if (isChecked) addToBottomBar(MenuItem.OPTIMISM,a) else removeFromBottomBar(MenuItem.OPTIMISM,a)
            }
            swtKindness.setOnCheckedChangeListener { a, isChecked ->
                if (isChecked) addToBottomBar(MenuItem.KINDESS,a) else removeFromBottomBar(MenuItem.KINDESS,a)
            }
            swtGiving.setOnCheckedChangeListener { a, isChecked ->
                if (isChecked) addToBottomBar(MenuItem.GIVING,a) else removeFromBottomBar(MenuItem.GIVING,a)
            }
            swtRespect.setOnCheckedChangeListener { a, isChecked ->
                if (isChecked) addToBottomBar(MenuItem.RESPECT,a) else removeFromBottomBar(MenuItem.RESPECT,a)
            }
        }
    }

    private fun addToBottomBar(menuItem: MenuItem,button: CompoundButton) {
        (activity as MainActivity).addToBottomBar(menuItem,button)
    }

    private fun removeFromBottomBar(menuItem: MenuItem, button: CompoundButton){
        (activity as MainActivity).removeFromBottomBar(menuItem,button)
    }

    private fun removeAllFromBottomBar(){
        (activity as MainActivity).removeAllFromBottomBar()
        with(binding){
            swtHappiness.isChecked = false
            swtOptimism.isChecked = false
            swtKindness.isChecked = false
            swtGiving.isChecked = false
            swtRespect.isChecked = false
        }
    }

    private fun setVisibility(isVisible: Boolean){
        (activity as MainActivity).setBottomBarVisibility(isVisible)
    }
}