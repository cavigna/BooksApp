package com.example.booksv1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksv1.databinding.RowItemBinding
import com.example.booksv1.jsonmodels.BookJson
import java.lang.NullPointerException

class BookAdapter(var books: BookJson) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    inner class BookViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            RowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.binding.apply {
            var autores = books.items[position].volumeInfo.authors
            tvtitulo.text = books.items[position].volumeInfo.title
            //tvautor.text = autores.joinToString { it.toString() }
            tvautor.text = autores[0]
            tvaO.text = books.items[position].volumeInfo.publishedDate
            try{
                Glide.with(imageViewBook.context)
                    .load(books.items.get(position).volumeInfo.imageLinks.thumbnail)
                    .fitCenter()
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageViewBook)
            }catch (e: NullPointerException){
                imageViewBook.setImageResource(R.drawable.noimage)
            }


        }
    }

    override fun getItemCount(): Int {
        return books.items.size
    }


}