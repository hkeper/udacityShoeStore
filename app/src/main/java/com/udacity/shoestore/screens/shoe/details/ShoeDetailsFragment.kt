package com.udacity.shoestore.screens.shoe.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoedetailsFragmentBinding
import com.udacity.shoestore.screens.shoe.ShoeViewModel

class ShoeDetailsFragment : Fragment() {

    private lateinit var binding: ShoedetailsFragmentBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.shoedetails_fragment, container, false)

        binding.shoeViewModel = shoeViewModel
        shoeViewModel.createShoe()

        return binding.root
    }

}