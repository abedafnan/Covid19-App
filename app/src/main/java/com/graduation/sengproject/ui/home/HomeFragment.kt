package com.graduation.sengproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.graduation.sengproject.R
import com.graduation.sengproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnInformation.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_infoFragment)
        }

        binding.btnNews.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_dashboard)
        }

        binding.btnSettings.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_notifications)
        }

        binding.btnProtection.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_protectionFragment)
        }

        return binding.root
    }
}