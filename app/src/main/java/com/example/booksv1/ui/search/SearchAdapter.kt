package com.example.booksv1.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksv1.R
import com.example.booksv1.databinding.RowItemBinding
import com.example.booksv1.jsonmodels.modelbook.LibroModelJson
import com.example.booksv1.jsonmodels.modelbook.Libros
import java.lang.NullPointerException

class SearchAdapter(libroModelJson : LibroModelJson) : RecyclerView.Adapter<SearchViewHolder>() {
    private var libros : List<Libros> = libroModelJson.items


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            RowItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val libroAcutal =libros[position].libro
        holder.binding.apply {
            try {

                tvtitulo.text = libroAcutal.title
                tvautor.text = libroAcutal.authors[0]
                tvano.text = libroAcutal.publishedDate
                Glide.with(imageViewBook.context)
                    .load(libroAcutal.imageLinks.thumbnail)
                    .fitCenter()
                    .into(imageViewBook)

            }catch (e: NullPointerException){
                cardRowItem.isVisible = false
                cardRowItem.visibility = View.GONE
                tvtitulo.text = "No Info"
                tvautor.text = "No Info"
                tvano.text = "No Info"
                imageViewBook.setImageResource(R.drawable.noimage)

            }
        }

        holder.binding.cardRowItem.setOnClickListener {
            val action = SearchFragmentDirections.actionNavigationDashboardToDetails(
                libroAcutal.imageLinks.thumbnail,
                libroAcutal.title,
                libroAcutal.authors[0],
                libroAcutal.description,
                libroAcutal.canonicalVolumeLink,
                libroAcutal.publishedDate

            )
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return libros.size
    }
}