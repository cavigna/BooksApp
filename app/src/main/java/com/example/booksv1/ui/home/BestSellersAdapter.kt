package com.example.booksv1.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksv1.databinding.BestSellersItemsBinding
import com.example.booksv1.jsonmodels.modelbestseller.BookNYModel
import com.example.booksv1.jsonmodels.modelbestseller.LibroNY

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

        holder.binding.apply {

            tvtituloBs.text = libroNY[position].title
            tvautorBs.text = libroNY[position].author
            tvposicionBs.text = "${libroNY[position].rank.toString()}°"
            Glide.with(imageBestseller.context)
                .load(libroNY[position].bookImage)
                .fitCenter()
                .into(imageBestseller)
        }
    }

    override fun getItemCount(): Int {
        return libroNY.size
    }
}

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


