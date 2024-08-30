package com.tunahankaryagdi.kekodfirstweekproject.respect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tunahankaryagdi.kekodfirstweekproject.R
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