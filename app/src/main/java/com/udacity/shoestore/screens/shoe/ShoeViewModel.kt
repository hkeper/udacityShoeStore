package com.udacity.shoestore.screens.shoe

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _listShoes =  MutableLiveData<MutableList<Shoe>>()
    val listOfShoes : LiveData<MutableList<Shoe>>
        get() = _listShoes

    var shoe: Shoe? = null

    init {
        createShoe()
        addDemoShoes()
    }

    private fun addDemoShoes() {
        _listShoes.value = mutableListOf(
            Shoe("Nike Blazer Low '77", 38.0, "Nike","Praised by the streets for its classic simplicity and comfort, the Nike Blazer Low '77 returns with its low-profile",
                mutableListOf("img1")),
            Shoe("Nike Blazer Low Platform", 40.0, "Nike","Praised for its classic simplicity and comfort, the Nike Blazer Low Platform elevates the hoops icon. The lifted midsole/outsole adds a confident look to the classic silhouette while the upper keeps the sleek proportions of the original.",
                mutableListOf("img2")),
            Shoe("Nike Blazer Low Platform", 37.0, "Nike","Let your attitude have the edge in your Nike Air Max Plus, a tuned Air experience that offers premium stability and unbelievable cushioning.",
                mutableListOf("img3"))
        )
    }

    fun onSave(v: View, shoe: Shoe){
        _listShoes.value?.add(shoe)
        v.findNavController().navigateUp()
    }

    fun onCancel(v: View){
        v.findNavController().navigateUp()
    }

    fun createShoe(){
        shoe = Shoe("", 0.0, "", "")
    }

}