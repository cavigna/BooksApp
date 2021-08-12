package com.example.booksv1.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksv1.databinding.BestSellersItemsBinding
import com.example.booksv1.databinding.DetailsFragmentBinding
import com.example.booksv1.jsonmodels.modelbestseller.BookNYModel
import com.example.booksv1.jsonmodels.modelbestseller.LibroNY
import com.example.booksv1.ui.details.Details

class BestSellersAdapter(bookNYModel: BookNYModel) : RecyclerView.Adapter<HomeViewHolder>() {
    private var libroNY : List<LibroNY> = bookNYModel.results.librosNy
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            BestSellersItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentBook = libroNY[position]

        val titulo = currentBook.title
        val imagen = currentBook.bookImage
        val autor = currentBook.author
        val descripcion = currentBook.description
        val url = currentBook.buyLinks[0].url
        val fecha = "No Info"

        holder.binding.apply {

            tvtituloBs.text = titulo
            tvautorBs.text = autor
            tvposicionBs.text = "${libroNY[position].rank.toString()}°"
            Glide.with(imageBestseller.context)
                .load(imagen)
                .fitCenter()
                .into(imageBestseller)
        }


        holder.binding.cardBestSeller.setOnClickListener {
            val action = HomeFragmentDirections
                .actionNavigationHomeToDetails(imagen,
                    titulo, autor, descripcion, url, fecha)
            holder.itemView.findNavController().navigate(action)
        }


    }



    override fun getItemCount(): Int {
        return libroNY.size
    }
}

//        holder.binding.cardBestSeller.setOnClickListener {
//            val context = it.context
//            val intento = Intent(context,Details::class.java)
//            val currentBook = libroNY[position]
//
//            intento.putExtra("imagen", currentBook.bookImage)
//            intento.putExtra("titulo", currentBook.title)
//            intento.putExtra("autor", currentBook.author)
//            intento.putExtra("descripción", currentBook.description)
//
//
//        }

/*

class BestSellersAdapter(bookNYModel: BookNYModel) : RecyclerView.Adapter<BookViewHolder>() {
    private var libroNY : List<LibroNY> = bookNYModel.results.librosNy
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(RowItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.binding.apply {
            tvtitulo.text = libroNY[position].title
            tvautor.text = libroNY[position].author
            Glide.with(imageViewBook.context)
                .load(libroNY[position].bookImage)
                .fitCenter()
                .into(imageViewBook)
        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}
 */


