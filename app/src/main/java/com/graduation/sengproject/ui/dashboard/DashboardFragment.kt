package com.graduation.sengproject.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.graduation.sengproject.R
import com.graduation.sengproject.databinding.FragmentDashboardBinding
import com.graduation.sengproject.models.Country
import com.graduation.sengproject.models.CountryShort
import com.graduation.sengproject.models.Global
import java.text.SimpleDateFormat
import java.util.*

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding
    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        binding.progress.visibility = View.VISIBLE

        binding.btnFilter.setOnClickListener {
            dashboardViewModel.getCountries()
        }

        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        dashboardViewModel.summary.observe(viewLifecycleOwner) {
            binding.progress.visibility = View.GONE
            val global = it.Global
            fillGlobalData(global)

            if (it.Countries.isNotEmpty()) {
                val adapter = DashboardAdapter(it.Countries)
                binding.recyclerStatistics.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.recyclerStatistics.adapter = adapter
            }
        }

        dashboardViewModel.countries.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                showCountriesList(it)
            }
        }

        dashboardViewModel.countryDetails.observe(viewLifecycleOwner) {
            binding.progress.visibility = View.GONE
            if (it.isNotEmpty()) {
                val adapter = DashboardAdapter2(it)
                binding.recyclerStatistics.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.recyclerStatistics.adapter = adapter
            }
        }

        return binding.root
    }

    private fun fillGlobalData(global: Global) {
        binding.tvNewConfirmed.text = global.NewConfirmed.toString()
        binding.tvNewDeaths.text = global.NewDeaths.toString()
        binding.tvNewRecovered.text = global.NewRecovered.toString()
        binding.tvGlobalDate.text = global.Date
    }

    private fun showCountriesList(countriesList: List<CountryShort>) {
        // Add the titles of the countries to a String list
        val countryNames = ArrayList<String>()
        for (country in countriesList) {
            countryNames.add(country.Country)
        }

        // Convert the list to an array to be displayed in the dialog
        val countries = countryNames.toTypedArray<CharSequence>()

        // Create the dialog and display countries
        val builder = AlertDialog.Builder(requireContext())
        builder.setItems(countries) { dialog, which ->
            val selectedCountry: CountryShort = countriesList[which]
            dashboardViewModel.getCountryDetails(selectedCountry.Country)
            binding.progress.visibility = View.VISIBLE
        }
        builder.show()
    }
}