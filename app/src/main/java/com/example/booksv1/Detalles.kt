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

            try{
                textViewDetallesDescripcion.text = intent.getStringExtra("detalle").toString()
                textViewDetallesAutor.text = intent.getStringExtra("autor").toString()
                textViewDetallesTitulo.text = intent.getStringExtra("titulo").toString()
                textViewDetallesYear.text = intent.getStringExtra("year").toString()

                Glide.with(imageViewDetalles.context)
                    .load(intent.getStringExtra("imagen"))
                    .fitCenter()
                    .into(imageViewDetalles)

            }catch (e:NullPointerException){
                imageViewDetalles.setImageResource(R.drawable.noimage)
                textViewDetallesDescripcion.text = "No info "



            }
        }
    }
}

/*
try {
                Glide.with(imageViewBook.context)
                    .load(books.items[position].libro.imageLinks.thumbnail)
                    .fitCenter()
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageViewBook)
            } catch (e: NullPointerException) {
                imageViewBook.setImageResource(R.drawable.noimage)
            }
 */