package com.graduation.sengproject.ui.news

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.graduation.sengproject.databinding.FragmentDashboardBinding
import com.graduation.sengproject.databinding.FragmentNewsBinding
import com.graduation.sengproject.models.Global
import java.util.*

class NewsFragment : Fragment(), NewsAdapter.CustomOnItemClickListener {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.progress.visibility = View.VISIBLE

        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)

        newsViewModel.news.observe(viewLifecycleOwner) {
            binding.progress.visibility = View.GONE

            if (it.news.isNotEmpty()) {
                val adapter = NewsAdapter(it.news, this)
                binding.recyclerNews.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.recyclerNews.adapter = adapter
            }
        }

        return binding.root
    }

    override fun onItemClick(url: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
}