package com.example.booksv1.ui.details

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.ImageLoader
import coil.load
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.example.booksv1.R
import com.example.booksv1.databinding.DetailsFragmentBinding
import com.example.booksv1.db.LibroEntity
import com.example.booksv1.db.LibrosDB
import com.example.booksv1.repository.DBRepository
import kotlinx.coroutines.launch

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







    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         val libroDao =LibrosDB.getDataBase(requireActivity().applicationContext).libroDao()
         val roomRepository  = DBRepository(libroDao)

        binding = DetailsFragmentBinding.inflate(inflater, container, false)

        var like = false
        val likeImageView = binding.likeImageview

        likeImageView.setOnClickListener{
            like = likeAnimation(likeImageView, R.raw.apple_event, like)
        }

        val titulo = args.titulo
        val autor = args.autor
        val descripcion = args.descripcion
        val imagen = args.imagen
        val url = args.urlLinks
        val fecha =

        binding.apply {
            tvTituloDetallesFragment.text = titulo
            tvAutorDetallesFrag.text = autor
            textViewDescripcion.text = descripcion

            imageDetail.load(args.imagen){
                placeholder(R.drawable.bookplaceholder)
            }
        }

        val boton = binding.buttonPrueba

        boton.setOnClickListener{
            lifecycleScope.launch {
                val libroEntity = LibroEntity(titulo, autor, "No Info",
                    descripcion,
                    getBitmap(imagen), url, "No Info", "No Info"
                )
                roomRepository.agregarLibro(libroEntity)

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

    private suspend fun  getBitmap(urlImage:String):Bitmap{
        val loading=ImageLoader(requireContext())
        val request=ImageRequest.Builder(requireContext())
            .data(urlImage)
            .build()
        val result = (loading.execute(request) as SuccessResult).drawable
        return(result as BitmapDrawable).bitmap
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