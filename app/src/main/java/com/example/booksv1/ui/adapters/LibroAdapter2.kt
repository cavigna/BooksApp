package com.example.booksv1.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksv1.BookViewHolder
import com.example.booksv1.Detalles
import com.example.booksv1.R
import com.example.booksv1.databinding.RowItemBinding
import com.example.booksv1.jsonmodels.modelshort.BookModelJson
import java.lang.NullPointerException

class LibroAdapter2(var libros:BookModelJson): RecyclerView.Adapter<BookViewHolder>() {
    val pepe = libros.listado.filterNotNull()

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

        var title :String
        var authors :String
        var image : String
        var descripcion : String

        holder.binding.apply {
            try {
                val title = libros.listado[position].info.title
                val authors = libros.listado[position].info.authors
                val image = libros.listado[position].info.linksImagenes.thumbnail

                tvtitulo.text = libros.listado[position].info.title
                tvautor.text = authors[0]
                tvano.text = libros.listado[position].info.publishedDate
                Glide.with(imageViewBook.context)
                    .load(image)
                    .fitCenter()
                    .into(imageViewBook)
            } catch (e: NullPointerException) {
                val title = "Sin titulo"

                tvtitulo.text = title
                tvautor.text = "No Info"
                tvano.text = "No Info"
                imageViewBook.setImageResource(R.drawable.noimage)



            }

        }

        holder.binding.cardBook.setOnClickListener {
            //holder.binding.imageViewBook.context.startActivity()
            val context =holder.binding.imageViewBook.context
            val intento = Intent(context, Detalles::class.java)

            intento.putExtra("titulo", libros.listado[position].info.title)

            intento.putExtra("autor", libros.listado[position].info.authors[0])
            intento.putExtra("imagen",libros.listado[position].info.linksImagenes.thumbnail)

            intento.putExtra("year", libros.listado[position].info.publishedDate)

            intento.putExtra("detalle",libros.listado[position].info.description )




            context.startActivity(intento)
        }

    }

    override fun getItemCount(): Int {
        return  libros.listado.size
    }


    private fun leo(){

        try {

            var titulo = libros.listado[0].info.title
        }catch (e: NullPointerException){
            var titulo = "Lo que sea"
        }






    }
}