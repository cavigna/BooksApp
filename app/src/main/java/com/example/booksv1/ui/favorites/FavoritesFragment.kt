package com.example.booksv1.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksv1.databinding.FragmentNotificationsBinding
import com.example.booksv1.db.LibrosDB
import com.example.booksv1.repository.DBRepository

class FavoritesFragment : Fragment() {

  private lateinit var favoritesViewModel: FavoritesViewModel
  private val myAdapter by lazy { FavoritesAdapter() }

//  private val favViewModel: FavoritesViewModel by viewModels {
//    FavoritesViewModelFactory((application  as LibroApplication ))
//  }

private var _binding: FragmentNotificationsBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {

    val libroDao = LibrosDB.getDataBase(requireActivity().applicationContext).libroDao()
    val roomRepository  = DBRepository(libroDao)
    val factory = FavoritesViewModelFactory(roomRepository)
    favoritesViewModel =
            ViewModelProvider(this, factory).get(FavoritesViewModel::class.java)

    _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
    val root: View = binding.root
    val recycler = binding.recyclerViewFavoritos

    val textView: TextView = binding.textNotifications
    favoritesViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })


    getFav()

    recycler.apply {
      layoutManager =  LinearLayoutManager(context)
      adapter = myAdapter

    }



    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

  fun getFav(){
    favoritesViewModel.allLibros.observe(viewLifecycleOwner, {

      myAdapter.setData(it)
      myAdapter.submitList(it)

    })
  }
}

/*
  fun getFav(){
    favoritesViewModel.allLibros.observe(this, Observer {
      libros->
      libros?.let {  }
    })
  }



 */