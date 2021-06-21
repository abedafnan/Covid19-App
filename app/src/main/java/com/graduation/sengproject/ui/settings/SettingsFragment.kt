package com.graduation.sengproject.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.graduation.sengproject.R
import com.graduation.sengproject.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)
        val binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.tvAccountInfo.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_notifications_to_accountFragment)
        }

        binding.tvDarkMode.setOnClickListener {

        }

        return binding.root
    }
}