package com.example.booksv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.booksv1.databinding.ActivityDetallesBinding
import java.lang.NullPointerException

class Detalles : AppCompatActivity() {
    private lateinit var binding: ActivityDetallesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            binding.textViewDetallesDescripcion.text = intent.getStringExtra("detalle").toString()
            try{
                Glide.with(imageViewDetalles.context)
                    .load(intent.getStringExtra("imagen"))
                    .fitCenter()
                    .into(imageViewDetalles)

            }catch (e:NullPointerException){

            }
        }
    }
}

/*
try {
                Glide.with(imageViewBook.context)
                    .load(books.items[position].volumeInfo.imageLinks.thumbnail)
                    .fitCenter()
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageViewBook)
            } catch (e: NullPointerException) {
                imageViewBook.setImageResource(R.drawable.noimage)
            }
 */