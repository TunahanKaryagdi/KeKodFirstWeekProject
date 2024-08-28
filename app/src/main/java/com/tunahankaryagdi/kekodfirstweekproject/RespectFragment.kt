package com.tunahankaryagdi.kekodfirstweekproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tunahankaryagdi.kekodfirstweekproject.databinding.FragmentOptimismBinding
import com.tunahankaryagdi.kekodfirstweekproject.databinding.FragmentRespectBinding


class RespectFragment : Fragment(R.layout.fragment_respect) {

    private lateinit var binding: FragmentRespectBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRespectBinding.inflate(inflater)
        return binding.root
    }
}