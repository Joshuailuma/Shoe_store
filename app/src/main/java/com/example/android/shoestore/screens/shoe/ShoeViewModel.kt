package com.example.android.shoestore.screens.shoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel: ViewModel() {

    private var _shoes = MutableLiveData<MutableList<MutableList<String>>>()
    val shoes : LiveData<MutableList<MutableList<String>>>
    get() = _shoes

    var _shoeName = MutableLiveData<String?>()
    val shoeName : MutableLiveData<String?>
        get() = _shoeName

    var _shoeCompany = MutableLiveData<String?>()
    val shoeCompany : LiveData<String?>
        get() = _shoeCompany

    var _shoeSize = MutableLiveData<String?>()
    val shoeSize : LiveData<String?>
        get() = _shoeSize

    var _shoeDescription = MutableLiveData<String?>()
    val shoeDescription : MutableLiveData<String?>
        get() = _shoeDescription

    var shoesList = mutableListOf(
    mutableListOf("Airmax", "Adidas","24", "Niceshoe"),
       mutableListOf("Airmax", "Adidas","24", "Niceshoe"),
    )

    fun addShoe(text: MutableList<String>)  {
        shoes.value?.add(text)
    }

    init {
        _shoes.value = shoesList
    }

    // Clear the fields after navigation is complete
    fun navigationComplete() {
        _shoeName.value = null
        _shoeCompany.value = null
        _shoeSize.value = null
        _shoeDescription.value = null
    }
}