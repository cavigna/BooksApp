package com.example.booksv1

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksv1.databinding.RowItemBinding
import com.example.booksv1.jsonmodels.BookJson
import java.lang.NullPointerException

class BookAdapter(
    var books: BookJson

) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

//val itemClickListener: OnBookClick
    inner class BookViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)

//    interface OnBookClick {
//        fun onCardClick(item: String, thumbnail: String)
//    }

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

            try {
                Glide.with(imageViewBook.context)
                    .load(books.items[position].volumeInfo.imageLinks.thumbnail)
                    .fitCenter()
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageViewBook)
            } catch (e: NullPointerException) {
                imageViewBook.setImageResource(R.drawable.noimage)
            }

//            holder.binding.cardBook.setOnClickListener {
//                //val intent = Intent(this, Detalles::class.java)
//            }

            holder.binding.cardBook.setOnClickListener {
                //holder.binding.imageViewBook.context.startActivity()
                val context =holder.binding.imageViewBook.context
                val intento = Intent(context, Detalles::class.java)
                intento.putExtra("detalle",books.items[position].volumeInfo.description )
                intento.putExtra("imagen", books.items[position].volumeInfo.imageLinks.thumbnail)
                context.startActivity(intento)
            }


//            cardBook.setOnClickListener {
//                itemClickListener.onCardClick(
//                    books.items[position].volumeInfo.description,
//                books.items[position].volumeInfo.imageLinks.thumbnail) }
//
        }
    }

    override fun getItemCount(): Int {
        return books.items.size
    }


}