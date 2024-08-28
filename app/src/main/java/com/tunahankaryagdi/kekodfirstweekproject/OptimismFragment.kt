package com.tunahankaryagdi.kekodfirstweekproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tunahankaryagdi.kekodfirstweekproject.databinding.FragmentKindnessBinding
import com.tunahankaryagdi.kekodfirstweekproject.databinding.FragmentOptimismBinding


class OptimismFragment : Fragment(R.layout.fragment_optimism) {

    private lateinit var binding: FragmentOptimismBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOptimismBinding.inflate(inflater)
        return binding.root
    }
}