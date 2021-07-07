package com.udacity.shoestore.screens.shoe.list

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListItemShoeBinding
import com.udacity.shoestore.databinding.ShoelistFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoe.ShoeViewModel

class ShoeListFragment : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: ShoelistFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.shoelist_fragment, container, false)

        binding.addShoeButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }

        shoeViewModel.listOfShoes.observe(viewLifecycleOwner, Observer { list ->
            list?.let {
                displayShoes(it)
            }
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().popBackStack()
        return NavigationUI.onNavDestinationSelected(item, findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun displayShoes(shoes: List<Shoe>) {
        shoes.forEach {
            val listItemShoeBinding: ListItemShoeBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.list_item_shoe, null, false)

            with(listItemShoeBinding) {
                shoeName.text =
                    getString(R.string.string_value, "Shoe name:", it.name)
                shoeCompany.text =
                    getString(R.string.string_value, "Company name:", it.company)
                shoeSize.text =
                    getString(R.string.double_value, "Shoe size:", it.size)
                shoeDescription.text =
                    getString(R.string.string_value, "Description:", it.description)

                binding.shoeListContainer.addView(root)
            }
        }
    }

}