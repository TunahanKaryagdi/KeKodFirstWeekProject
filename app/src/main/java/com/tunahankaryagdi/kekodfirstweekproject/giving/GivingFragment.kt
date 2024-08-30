package com.tunahankaryagdi.kekodfirstweekproject.giving

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tunahankaryagdi.kekodfirstweekproject.R
import com.tunahankaryagdi.kekodfirstweekproject.databinding.FragmentGivingBinding


class GivingFragment : Fragment(R.layout.fragment_giving) {

    private lateinit var binding: FragmentGivingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGivingBinding.inflate(inflater)
        return binding.root
    }
}