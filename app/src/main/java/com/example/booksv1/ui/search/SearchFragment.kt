package com.example.booksv1.ui.search

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView.*

import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksv1.databinding.FragmentSearchBinding
import com.example.booksv1.repository.BookRepository
import com.example.booksv1.retrofit.RetrofitInstance
import kotlinx.coroutines.launch
import java.util.*

class SearchFragment : Fragment(),
  OnQueryTextListener {

  private lateinit var searchViewModel: SearchViewModel
  private  var busqueda : String? =null

  //private lateinit var searchAdapter : SearchAdapter

  private lateinit var repository: BookRepository


private var _binding: FragmentSearchBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    repository = BookRepository(RetrofitInstance.retroService)
    val factory = SearchViewModelFactory(repository)
    searchViewModel =
            ViewModelProvider(this, factory).get(SearchViewModel::class.java)

    _binding = FragmentSearchBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val searchView = binding.searchViewFragment


    searchView.setOnQueryTextListener(this)

    val textView: TextView = binding.textDashboard
    searchViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    getBookByName("hobbit")


    return root
  }

  private fun searchByQuery(query: String?){
    val recycler : RecyclerView = binding.recyclerViewSearch
    searchViewModel.searchByQuery(query!!)
    searchViewModel.librosLiveData.observe(viewLifecycleOwner){
      recycler.apply {
        layoutManager = LinearLayoutManager(context)
        adapter = SearchAdapter(searchViewModel.librosLiveData.value!!)
      }
    }
  }

  private fun getBookByName(palabra: String) {
    lifecycleScope.launch {
      val response = RetrofitInstance.retroService.pruebabuscar(palabra)
      val data = response.body()!!

      if (response.isSuccessful) {

        Log.v("Pedido", response.raw().toString())
        Log.v("Pedido", response.raw().toString())
        Log.v("Libro", response.body().toString())



      }else{
        Log.v("Pedido", response.raw().toString())
        Log.v("Libro", response.body().toString())
        Log.v("Caca", "caca")
      }
    }
  }

  override fun onQueryTextSubmit(query: String?): Boolean {
    if (!query.isNullOrEmpty()) {
      busqueda = query.lowercase(Locale.getDefault())
      searchByQuery(busqueda!!)



    }
    return true
  }

  override fun onQueryTextChange(newText: String?): Boolean {
    return true
  }

//  private fun hideKeyboard() {
//    val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//    imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
//  }


override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}