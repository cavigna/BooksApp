package com.example.booksv1.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.example.booksv1.R
import com.example.booksv1.databinding.DetailsFragmentBinding
import com.example.booksv1.db.LibrosDB
import com.example.booksv1.repository.DBRepository

class Details : Fragment() {


    companion object {
        fun newInstance() = Details()
    }

//    private  var _binding: DetailsFragmentBinding? = null
//
//    private val binding = _binding!!

    private lateinit var viewModel: DetailsViewModel
    private lateinit var binding: DetailsFragmentBinding
    private val args: DetailsArgs by navArgs()

    //ROOM
    //private val libroDao =LibrosDB.getDataBase(requireActivity().applicationContext).libroDao()
    //private val roomRepository  = DBRepository(libroDao)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding = DetailsFragmentBinding.inflate(inflater, container, false)

        var like = false
        val likeImageView = binding.likeImageview

        likeImageView.setOnClickListener{
            like = likeAnimation(likeImageView, R.raw.apple_event, like)
        }

        binding.apply {
            tvTituloDetallesFragment.text = args.titulo
            tvAutorDetallesFrag.text = args.autor
            textViewDescripcion.text = args.descripcion
            imageDetail.load(args.imagen){
                placeholder(R.drawable.bookplaceholder)
            }
        }

        /*
                Glide.with(imageDetail.context)
                .load(args.imagen)
                //.override(5000,5000)
                .fitCenter()
                .into(imageDetail)
            tvTituloDetallesFragment.text = args.titulo
            tvAutorDetallesFrag.text = args.autor
            textViewDescripcion.text = args.descripcion
         */

        //val libroDao =LibrosDB.getDataBase(requireContext()).libroDao()


        return binding.root


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

    }

    private fun likeAnimation(imageView: LottieAnimationView,
    animation:Int, like:Boolean):Boolean{
        if (!like){
            imageView.setAnimation(animation)
            imageView.playAnimation()
        }else{
            imageView.setImageResource(R.drawable.twitter_like)

        }
        return !like

    }


}
/*
            Glide.with(imageDetail.context)
                .load(args.imagen)
                //.override(5000,5000)
                .fitCenter()
                .into(imageDetail)
 */

/*

class Details : Fragment() {


    companion object {
        fun newInstance() = Details()
    }

//    private  var _binding: DetailsFragmentBinding? = null
//
//    private val binding = _binding!!

    private lateinit var viewModel: DetailsViewModel
    private lateinit var binding: DetailsFragmentBinding
    private val args: DetailsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        binding = DetailsFragmentBinding.inflate(inflater, container, false)


        binding.apply {
            Glide.with(imageDetail.context)
                .load(args.imagen)
                //.override(5000,5000)
                .fitCenter()
                .into(imageDetail)
            tvTituloDetallesFragment.text = args.titulo
            tvAutorDetallesFrag.text = args.autor
            textViewDescripcion.text = args.descripcion
        }
        return binding.root


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

    }


}

 */