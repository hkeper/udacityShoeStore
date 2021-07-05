package com.udacity.shoestore.screens.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionFragmentBinding
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.instruction_fragment, container, false)

        binding.shoeListButton.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
        }

        return binding.root
    }

}