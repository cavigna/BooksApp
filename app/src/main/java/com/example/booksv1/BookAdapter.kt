package com.example.booksv1

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksv1.databinding.RowItemBinding
import com.example.booksv1.jsonmodels.modellong.BookJson
import java.lang.NullPointerException

class BookAdapter(var books: BookJson) : RecyclerView.Adapter<BookViewHolder>() {


    //inner class BookViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)


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
            //tvautor.text = autores[0]

            try {
                tvtitulo.text = books.items[position].volumeInfo.title
                tvautor.text = autores[0]
                tvaO.text = books.items[position].volumeInfo.publishedDate

                Glide.with(imageViewBook.context)
                    .load(books.items[position].volumeInfo.imageLinks.thumbnail)
                    .fitCenter()
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageViewBook)


            }catch (e: NullPointerException){
                tvtitulo.text = "No Info"
                tvautor.text = "No Info"
                tvaO.text = "No Info"
                imageViewBook.setImageResource(R.drawable.noimage)

            }

            holder.binding.cardBook.setOnClickListener {
                //holder.binding.imageViewBook.context.startActivity()
                val context =holder.binding.imageViewBook.context
                val intento = Intent(context, Detalles::class.java)
                intento.putExtra("detalle",books.items[position].volumeInfo.description )
                intento.putExtra("imagen", books.items[position].volumeInfo.imageLinks.thumbnail)
                intento.putExtra("autor", books.items[position].volumeInfo.authors[0])
                intento.putExtra("year", books.items[position].volumeInfo.publishedDate)
                intento.putExtra("titulo", books.items[position].volumeInfo.title)
                context.startActivity(intento)
            }



        }
    }

    override fun getItemCount(): Int {
        return books.items.size
    }


}