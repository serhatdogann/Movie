package com.example.movie.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.databinding.FragmentSplahBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplahFragment : Fragment() {

    private var _binding:FragmentSplahBinding?=null
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSplahBinding.inflate(inflater,container,false)
        val view=binding?.root

        view?.let {
            Handler(Looper.getMainLooper()).postDelayed({
                it.findNavController().navigate(R.id.action_splahFragment_to_mainFragment)
            },1200)
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}