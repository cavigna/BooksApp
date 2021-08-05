package com.example.booksv1

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksv1.databinding.ActivityNyBinding
import com.example.booksv1.repository.BookRepository
import com.example.booksv1.retrofit.RetrofitInstance
import com.example.booksv1.ui.adapters.BestSellersAdapter
import com.example.booksv1.viewmodel.BookViewModel

class NyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNyBinding

    private lateinit var viewModel: BookViewModel
    private lateinit var repository: BookRepository
    private lateinit var bestSellersAdapter: BestSellersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = BookRepository(RetrofitInstance.retroService)
        val factory = BookViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(BookViewModel::class.java)
        bestSellers()

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_ny)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun bestSellers(){
        viewModel.bestSellers()
        viewModel.bestSellersLiveData.observe(this){
            binding.recyclerBestSellers.apply {
                layoutManager = LinearLayoutManager(this@NyActivity)
                bestSellersAdapter = BestSellersAdapter(viewModel.bestSellersLiveData.value!!)
                adapter = bestSellersAdapter
                adapter?.notifyDataSetChanged()
            }
        }
    }
}