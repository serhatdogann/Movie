package com.example.movie.ui.fragments.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private var _binding:FragmentFavoriteBinding?=null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding= FragmentFavoriteBinding.inflate(inflater,container,false)
        val view=binding?.root
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}