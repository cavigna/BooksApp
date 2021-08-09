package com.example.booksv1.ui.details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.booksv1.R
import com.example.booksv1.databinding.DetailsFragmentBinding

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


/*
class Details : Fragment() {
    private  var _binding: DetailsFragmentBinding? = null

    private val binding = _binding!!

    companion object {
        fun newInstance() = Details()
    }

    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        // TODO: Use the ViewModel


    }

}
 */