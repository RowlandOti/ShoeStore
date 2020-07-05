package com.udacity.shoestore.ui.shoedetail

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.data.model.Shoe

class ShoeDetailViewModel : ViewModel() {

    private val shoe = MutableLiveData<Shoe>(Shoe("", 0.0, "", "", listOf()))

    fun getShoe(): LiveData<Shoe> {
        return shoe
    }

    fun setShoe(newShoe: Shoe) {
        shoe.postValue(newShoe)
    }
}