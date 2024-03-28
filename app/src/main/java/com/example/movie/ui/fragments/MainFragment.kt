package com.example.movie.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.movie.R
import com.example.movie.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var navController: NavController

    private var _binding: FragmentMainBinding?=null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        navController=findNavController()
        val view = binding?.root
        setupTabBar()
        return view
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    private fun setupTabBar() {
        binding?.bottomNavbar?.selectedItemId=R.id.homeid
        binding?.bottomNavbar?.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeid -> {
                    childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.homeFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.favoritesid -> {
                    childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.favoriteFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.settingid -> {
                    childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.settingsFragment)
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }
        }
    }

}


