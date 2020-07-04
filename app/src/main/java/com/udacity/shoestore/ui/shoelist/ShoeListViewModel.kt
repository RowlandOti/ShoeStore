package com.udacity.shoestore.ui.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.data.model.Shoe

class ShoeListViewModel : ViewModel() {

    private val shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    fun getShoeList(): LiveData<MutableList<Shoe>> {
        return shoeList
    }

    fun setShoeList(list: MutableList<Shoe>) {
        shoeList.postValue(list)
    }

    fun addShoeToList(shoe: Shoe) {
        shoeList.value?.add(shoe)
    }
}