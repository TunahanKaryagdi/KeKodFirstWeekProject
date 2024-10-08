package com.tunahankaryagdi.kekodfirstweekproject.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.tunahankaryagdi.kekodfirstweekproject.MainActivity
import com.tunahankaryagdi.kekodfirstweekproject.MainViewModel
import com.tunahankaryagdi.kekodfirstweekproject.MenuItem
import com.tunahankaryagdi.kekodfirstweekproject.R
import com.tunahankaryagdi.kekodfirstweekproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by activityViewModels()


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
        observe()
    }

    private fun setUiListeners() {

        with(binding) {
            swtEgo.setOnCheckedChangeListener { _, isChecked -> viewModel.setEgoSwitch(isChecked) }
            swtHappiness.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setHappinessSwitch(
                    isChecked
                )
            }
            swtOptimism.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setOptimismSwitch(
                    isChecked
                )
            }
            swtKindness.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setKindnessSwitch(
                    isChecked
                )
            }
            swtGiving.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setGivingSwitch(
                    isChecked
                )
            }
            swtRespect.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setRespectSwitch(
                    isChecked
                )
            }
        }
    }

    private fun addToBottomBar(menuItem: MenuItem) {
        val isSuccess = (activity as MainActivity).addToBottomBar(menuItem)
        if (isSuccess) return

        when (menuItem) {
            MenuItem.HAPPINESS -> viewModel.setHappinessSwitch(false)
            MenuItem.OPTIMISM -> viewModel.setOptimismSwitch(false)
            MenuItem.KINDESS -> viewModel.setKindnessSwitch(false)
            MenuItem.GIVING -> viewModel.setGivingSwitch(false)
            MenuItem.RESPECT -> viewModel.setRespectSwitch(false)
            else -> {}
        }

    }

    private fun removeFromBottomBar(menuItem: MenuItem) {
        val isSuccess = (activity as MainActivity).removeFromBottomBar(menuItem)
        if (!isSuccess) return

        when (menuItem) {
            MenuItem.HAPPINESS -> viewModel.setHappinessSwitch(false)
            MenuItem.OPTIMISM -> viewModel.setOptimismSwitch(false)
            MenuItem.KINDESS -> viewModel.setKindnessSwitch(false)
            MenuItem.GIVING -> viewModel.setGivingSwitch(false)
            MenuItem.RESPECT -> viewModel.setRespectSwitch(false)
            else -> {}
        }


    }

    private fun removeAllFromBottomBar() {
        (activity as MainActivity).removeAllFromBottomBar()
        with(binding) {
            swtHappiness.isChecked = false
            swtOptimism.isChecked = false
            swtKindness.isChecked = false
            swtGiving.isChecked = false
            swtRespect.isChecked = false
        }
    }

    private fun setVisibility(isVisible: Boolean) {
        (activity as MainActivity).setBottomBarVisibility(isVisible)
    }

    private fun observe() {

        with(viewModel) {
            egoSwitch.observe(viewLifecycleOwner) { isChecked ->
                with(binding) {
                    if (isChecked) {
                        setSwitchesEnabled(false)
                        removeAllFromBottomBar()
                        setVisibility(false)
                    } else {
                        setSwitchesEnabled(true)
                        setVisibility(true)
                        addToBottomBar(MenuItem.HOME)
                    }
                    swtEgo.isChecked = isChecked
                }
            }
            happinessSwitch.observe(viewLifecycleOwner) { isChecked ->
                if (isChecked) addToBottomBar(MenuItem.HAPPINESS) else removeFromBottomBar(MenuItem.HAPPINESS)
                binding.swtHappiness.isChecked = isChecked
            }
            optimismSwitch.observe(viewLifecycleOwner) { isChecked ->
                if (isChecked) addToBottomBar(MenuItem.OPTIMISM) else removeFromBottomBar(MenuItem.OPTIMISM)
                binding.swtOptimism.isChecked = isChecked

            }
            kindnessSwitch.observe(viewLifecycleOwner) { isChecked ->
                if (isChecked) addToBottomBar(MenuItem.KINDESS) else removeFromBottomBar(MenuItem.KINDESS)
                binding.swtKindness.isChecked = isChecked

            }
            givingSwitch.observe(viewLifecycleOwner) { isChecked ->
                if (isChecked) addToBottomBar(MenuItem.GIVING) else removeFromBottomBar(MenuItem.GIVING)
                binding.swtGiving.isChecked = isChecked

            }
            respectSwitch.observe(viewLifecycleOwner) { isChecked ->
                if (isChecked) addToBottomBar(MenuItem.RESPECT) else removeFromBottomBar(MenuItem.RESPECT)
                binding.swtRespect.isChecked = isChecked

            }
        }
    }

    private fun setSwitchesEnabled(value: Boolean) {
        with(binding) {
            swtHappiness.isEnabled = value
            swtOptimism.isEnabled = value
            swtKindness.isEnabled = value
            swtGiving.isEnabled = value
            swtRespect.isEnabled = value
        }
    }
}