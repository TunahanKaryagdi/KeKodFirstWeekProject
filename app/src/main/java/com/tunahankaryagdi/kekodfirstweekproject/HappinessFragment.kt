package com.tunahankaryagdi.kekodfirstweekproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tunahankaryagdi.kekodfirstweekproject.databinding.FragmentGivingBinding
import com.tunahankaryagdi.kekodfirstweekproject.databinding.FragmentHappinessBinding

class HappinessFragment : Fragment(R.layout.fragment_happiness) {

    private lateinit var binding: FragmentHappinessBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHappinessBinding.inflate(inflater)
        return binding.root
    }
}