package com.example.booksv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
//import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksv1.retrofit.RetrofitInstance.retroService
import com.example.booksv1.databinding.ActivityMainBinding
import com.example.booksv1.jsonmodels.modellong.BookJson
import com.example.booksv1.repository.BookRepository
import com.example.booksv1.viewmodel.BookViewModel
import kotlinx.coroutines.launch
import java.util.*
//BookAdapter.OnBookClick
class MainActivity : AppCompatActivity(),SearchView.OnQueryTextListener
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var bookAdapter: BookAdapter
    private var busqueda: String? = null
    private lateinit var resultado : BookJson

    private lateinit var viewModel: BookViewModel
    private lateinit var repository: BookRepository

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchView.setOnQueryTextListener(this)


        repository = BookRepository(retroService)
        val factory = BookViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(BookViewModel::class.java)
        otromas("El Aleph")


    }

    private fun recyclerInit(books : BookJson) = binding.recyclerView.apply {
        bookAdapter = BookAdapter(books)
        adapter = bookAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun getBookByName(palabra : String){
        lifecycleScope.launch{
            val response = retroService.searchByName(palabra)
            val data = response.body()!!

            if (response.isSuccessful){
                //Log.v("Libros", response.body().toString())
                //Log.v("Pedido", response.raw().toString())
                recyclerInit(data)
                resultado = data

            }
        }
    }





    private fun otromas(busqueda:String){
        viewModel.librosPorBusqueda(busqueda)
        viewModel.librosMutableLiveData.observe(this){
            Log.v("fafafa", viewModel.librosMutableLiveData.value.toString())
        }




    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            busqueda = query.lowercase(Locale.getDefault())
            getBookByName(busqueda!!)
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
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
}

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
                Log.v("Libros", response.body().toString())
                binding.tvprueba.text = data.items.get(0).volumeInfo.title

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
//                //Log.v("Libros", response.body().toString())
//                Log.v("Pedido", response.raw().toString())
//                binding.tvprueba.text = data.items.get(0).volumeInfo.title
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
                Log.v("Libros", response.body().toString())
            }
        }
    }
 */