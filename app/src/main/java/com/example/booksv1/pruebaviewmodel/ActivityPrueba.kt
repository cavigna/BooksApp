package com.example.booksv1.pruebaviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.booksv1.databinding.ActivityPruebaBinding

class ActivityPrueba : AppCompatActivity() {
    private lateinit var binding: ActivityPruebaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPruebaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}