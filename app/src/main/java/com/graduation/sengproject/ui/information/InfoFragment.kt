package com.graduation.sengproject.ui.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.graduation.sengproject.R
import com.graduation.sengproject.ui.protection.ProtectionFragment
import com.graduation.sengproject.ui.protection.ProtectionViewModel

class InfoFragment : Fragment() {

    companion object {
        fun newInstance() = ProtectionFragment()
    }

    private lateinit var viewModel: ProtectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProtectionViewModel::class.java)
        // TODO: Use the ViewModel

    }
}