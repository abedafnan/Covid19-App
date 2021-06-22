package com.graduation.sengproject.ui.protection

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.graduation.sengproject.R
import java.lang.Exception

class ProtectionFragment : Fragment() {

    companion object {
        fun newInstance() = ProtectionFragment()
    }

    private lateinit var viewModel: ProtectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_protection, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProtectionViewModel::class.java)
        // TODO: Use the ViewModel
    }
}