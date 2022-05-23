package com.d3if3116.hitung_luassegitiga.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.d3if3116.hitung_luassegitiga.databinding.FragmentStoryBinding

class HistoryFragment: Fragment() {

    private lateinit var binding: FragmentStoryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentStoryBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}