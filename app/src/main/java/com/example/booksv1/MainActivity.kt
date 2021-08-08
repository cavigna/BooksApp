package com.example.booksv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope

//import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksv1.retrofit.RetrofitInstance.retroService
import com.example.booksv1.databinding.ActivityMainBinding
import com.example.booksv1.jsonmodels.modellong.BookJson
import com.example.booksv1.repository.BookRepository
import com.example.booksv1.ui.adapters.BookAdapter
import com.example.booksv1.viewmodel.BookViewModel
import com.example.booksv1.viewmodel.LibroAdapter
import com.example.booksv1.ui.adapters.LibroAdapter2
import kotlinx.coroutines.launch
import java.util.*

//BookAdapter.OnBookClick
class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bookAdapter: BookAdapter
    private var busqueda: String? = null

    private lateinit var viewModel: BookViewModel
    private lateinit var repository: BookRepository

    private lateinit var libroAdapter: LibroAdapter
    private lateinit var libroAdapter2: LibroAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchView.setOnQueryTextListener(this)


        repository = BookRepository(retroService)
        val factory = BookViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(BookViewModel::class.java)

        nyTry()


    }

    private fun recyclerInit(books: BookJson) = binding.recyclerView.apply {
        bookAdapter = BookAdapter(books)
        adapter = bookAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }



    private fun getBookByName(palabra: String) {
        lifecycleScope.launch {
            val response = retroService.searchByName(palabra)
            val data = response.body()!!

            if (response.isSuccessful) {

                //Log.v("Pedido", response.raw().toString())
                recyclerInit(data)


            }
        }
    }



    private fun initRecycler(busqueda: String) {

        viewModel.librosPorBusqueda(busqueda)
        viewModel.librosMutableLiveData.observe(this) {

            binding.recyclerView.apply {

                libroAdapter2 = LibroAdapter2(viewModel.librosMutableLiveData.value!!)
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = libroAdapter2
                adapter?.notifyDataSetChanged()
                 //Log.v("fafafa", viewModel.librosMutableLiveData.value.toString())
                //Log.v("Pedido", response.raw().toString())
            }
        }


    }

    private fun nyTry(){
        viewModel.bestSellers()
        viewModel.bestSellersLiveData.observe(this){
            Log.v("fafafa", viewModel.bestSellersLiveData.value.toString())
        }
    }




    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            busqueda = query.lowercase(Locale.getDefault())
            //getBookByName(busqueda!!)

            initRecycler(busqueda!!)

        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    fun otromas(busqueda: String) {
        viewModel.librosPorBusqueda(busqueda)
        viewModel.librosMutableLiveData.observe(this) {
            Log.v("fafafa", viewModel.librosMutableLiveData.value.toString())
        }


    }

    /*
     private fun hideKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }
     */
}

/*
    override fun onQueryTextSubmit(query: String?): Boolean {
    if(!query.isNullOrEmpty()){
        busqueda = query.lowercase(Locale.getDefault())
        getBookByName(busqueda!!)
    }
    return true
}
 */

//    override fun onCardClick(item: String, thumbnail: String) {
//        val intent = Intent(this, Detalles::class.java)
//        //intent.put.putExtra("algo", resultado)
//        startActivity(intent)
//    }


//git branch -m master main
//git fetch origin
//git branch -u origin/main main
//git remote set-head origin -a

/*
package com.example.booksv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.booksv1.retrofit.RetrofitInstance.retroService
import com.example.booksv1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        lifecycleScope.launchWhenCreated {
            val response = retroService.searchByName()
            val data = response.body()!!

            if (response.isSuccessful){
                Log.v("Libro", response.body().toString())
                binding.tvprueba.text = data.items.get(0).libro.title

            }
        }
    }

    private fun getBookByName(){
        lifecycleScope.launch{

        }
    }
}
 */

/*
//        lifecycleScope.launchWhenCreated {
//            val response = retroService.searchByName(" douglas adams")
//            val data = response.body()!!
//
//            if (response.isSuccessful){
//                //Log.v("Libro", response.body().toString())
//                Log.v("Pedido", response.raw().toString())
//                binding.tvprueba.text = data.items.get(0).libro.title
//                recyclerInit(data)
//
//            }
//        }
 */

/*
viewModel.librosLiveData.observe(this){
            Log.v("rompedor", viewModel.librosLiveData.toString())
            lifecycleScope.launchWhenCreated {
                viewModel.librosPorNombre("Sinsajo")
                Log.v("rompedor", viewModel.librosLiveData.toString())
            }

        }
 */

/*
    private fun imprimir(palabra: String){
        lifecycleScope.launch{
            val response = retroService.searchByQuery(palabra)
            val data = response.body()!!

            if(response.isSuccessful){
                Log.v("Libro", response.body().toString())
            }
        }
    }
 */