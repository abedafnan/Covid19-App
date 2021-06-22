package com.graduation.sengproject.ui.dashboard

import com.graduation.sengproject.databinding.ItemCasesBinding
import com.graduation.sengproject.models.Country
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.graduation.sengproject.models.CountryArea

class DashboardAdapter2(var data: List<CountryArea>)
    :RecyclerView.Adapter<DashboardAdapter2.DashboardViewHolder>(){

    inner class DashboardViewHolder(var itemPreviousInterviewBinding: ItemCasesBinding) :
        RecyclerView.ViewHolder(itemPreviousInterviewBinding.root){
        fun bind(interview: CountryArea){
            itemPreviousInterviewBinding.tvCountry.text = interview.Country
            itemPreviousInterviewBinding.tvNewConfirmed.text = interview.Confirmed.toString()
            itemPreviousInterviewBinding.tvNewDeaths.text = interview.Deaths.toString()
            itemPreviousInterviewBinding.tvNewRecovered.text = interview.Recovered.toString()
            itemPreviousInterviewBinding.tvGlobalDate.text = interview.Date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val binding = ItemCasesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DashboardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val round = data[position]

        holder.bind(round)
    }

    override fun getItemCount() = data.size
}