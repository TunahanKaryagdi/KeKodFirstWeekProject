package com.tunahankaryagdi.kekodfirstweekproject.optimism

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tunahankaryagdi.kekodfirstweekproject.R
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