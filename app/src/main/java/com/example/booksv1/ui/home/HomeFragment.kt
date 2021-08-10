package com.example.booksv1.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksv1.databinding.FragmentHomeBinding
import com.example.booksv1.db.LibroDao
import com.example.booksv1.db.LibrosDB
import com.example.booksv1.repository.BookRepository
import com.example.booksv1.retrofit.RetrofitInstance

class HomeFragment : Fragment() {

  private lateinit var homeViewModel: HomeViewModel
private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  // *************** //

  private lateinit var repository: BookRepository
  //private val libroDao = LibrosDB.getDataBase(Context().applicationContext).libroDao()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {


    repository = BookRepository(RetrofitInstance.retroService)
    val factory = HomeViewModelFactory(repository)
    homeViewModel =
      ViewModelProvider(this, factory).get(HomeViewModel::class.java)


//    homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textHome
    homeViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    bestSellers()





    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
private fun bestSellers(){
  val recycler : RecyclerView = binding.recyclerViewFragment
  homeViewModel.bestSellers()
  homeViewModel.bestSellersLiveData.observe(viewLifecycleOwner){
    recycler.apply {
      layoutManager =  LinearLayoutManager(context)
      adapter = BestSellersAdapter(homeViewModel.bestSellersLiveData.value!!)


    }
  }

}


}