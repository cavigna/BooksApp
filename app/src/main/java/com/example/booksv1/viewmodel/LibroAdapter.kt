package com.example.booksv1.viewmodel


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.booksv1.BookViewHolder
import com.example.booksv1.R
import com.example.booksv1.databinding.RowItemBinding
import com.example.booksv1.jsonmodels.modelshort.BookModelJson
import java.lang.NullPointerException
/*

    init {
        libros2.observe(lifecycleOwner){
            libro = libros2.value
        }
    }
 */
//class LibroAdapter( libros2: LiveData<BookModelJson?>, val lifecycleOwner: LifecycleOwner): ListAdapter<BookModelJson, BookViewHolder>(DiffUtilCallback) {
//class LibroAdapter( libros2: LiveData<BookModelJson?>): ListAdapter<BookModelJson, BookViewHolder>(DiffUtilCallback) {
//class LibroAdapter(private var libro: BookModelJson?)
class LibroAdapter( libros2: BookModelJson?): ListAdapter<BookModelJson, BookViewHolder>(DiffUtilCallback) {
    private var libros :BookModelJson? = libros2!!


    //inner class LibroViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)


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
        if (libros !=null) {
            holder.binding.apply {
                val title = libros!!.listado[position].info.title
                val authors = libros!!.listado[position].info.authors
                val image = libros!!.listado[position].info.linksImagenes.thumbnail

                try {
                    tvtitulo.text = title
                    tvautor.text = authors[0]
                    Glide.with(imageViewBook.context)
                        .load(image)
                        .fitCenter()
                        .into(imageViewBook)
                } catch (e: NullPointerException) {
                    tvtitulo.text = "No Info"
                    tvautor.text = "No Info"
                    tvano.text = "No Info"
                    imageViewBook.setImageResource(R.drawable.noimage)

                }

            }
        }

    }

    object DiffUtilCallback : DiffUtil.ItemCallback<BookModelJson>() {
        override fun areItemsTheSame(oldItem: BookModelJson, newItem: BookModelJson): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BookModelJson, newItem: BookModelJson): Boolean {
            return oldItem == newItem
        }


    }
}

/*
            holder.binding.cardBook.setOnClickListener {
                //holder.binding.imageViewBook.context.startActivity()
                val context =holder.binding.imageViewBook.context
                val intento = Intent(context, Detalles::class.java)
                intento.putExtra("detalle",books.items[position].libro.description )
                intento.putExtra("imagen", books.items[position].libro.imageLinks.thumbnail)
                intento.putExtra("autor", books.items[position].libro.authors[0])
                intento.putExtra("year", books.items[position].libro.publishedDate)
                intento.putExtra("titulo", books.items[position].libro.title)
                context.startActivity(intento)
            }

 */