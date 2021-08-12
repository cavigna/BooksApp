package com.example.booksv1.ui.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.booksv1.databinding.RowItemBinding
import com.example.booksv1.db.LibroEntity

class FavoritesAdapter() : ListAdapter<LibroEntity, FavoritesViewHolder>(ComparacionLibros()) {

    private var libros = emptyList<LibroEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        return FavoritesViewHolder(
            RowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        var libro = libros[position]
        holder.binding.apply {
            tvtitulo.text = libro.title
            tvautor.text = libro.autor
            tvano.text = libro.fecha
            imageViewBook.load(libro.imagen)
        }
    }

    fun setData(libros:List<LibroEntity>){
        this.libros = libros
    }

}

class ComparacionLibros: DiffUtil.ItemCallback<LibroEntity>() {
    override fun areItemsTheSame(oldItem: LibroEntity, newItem: LibroEntity): Boolean {
        return oldItem.id ==newItem.id
    }

    override fun areContentsTheSame(oldItem: LibroEntity, newItem: LibroEntity): Boolean {
        return oldItem == newItem
    }

}

