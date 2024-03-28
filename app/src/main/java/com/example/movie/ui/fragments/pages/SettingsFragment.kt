package com.example.movie.ui.fragments.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.databinding.FragmentHomeBinding
import com.example.movie.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private var _binding:FragmentSettingsBinding?=null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSettingsBinding.inflate(inflater,container,false)
        val view=binding?.root
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}