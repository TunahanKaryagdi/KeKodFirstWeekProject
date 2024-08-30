package com.tunahankaryagdi.kekodfirstweekproject.kindness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tunahankaryagdi.kekodfirstweekproject.R
import com.tunahankaryagdi.kekodfirstweekproject.databinding.FragmentKindnessBinding

class KindnessFragment : Fragment(R.layout.fragment_kindness) {

    private lateinit var binding: FragmentKindnessBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKindnessBinding.inflate(inflater)
        return binding.root
    }
}