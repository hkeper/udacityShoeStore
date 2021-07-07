package com.udacity.shoestore.utility

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.InverseMethod
import timber.log.Timber
import java.text.ParseException

object Converter {
    @InverseMethod("textToDecimal")
    @JvmStatic fun decimalToText(view: EditText, shoeOldSize: Double, shoeSize: Double): String {
        try {
            val editTextValue = view.text.toString()
            if (editTextValue.isNotEmpty())
            {
                if (editTextValue.toDouble() == shoeSize)
                    return view.text.toString()
            }
        }
        catch (ex: ParseException) {
            Timber.e("Something wrong with shoe size number")
        }
        return shoeSize.toString()
    }

    @JvmStatic fun textToDecimal(view: EditText, shoeOldSize: Double, shoeSize: String): Double {
        try {
            return shoeSize.toDouble()
        }
        catch (ex: Exception){
            Timber.e("Bad shoe size number")
            return shoeOldSize
        }
    }
}