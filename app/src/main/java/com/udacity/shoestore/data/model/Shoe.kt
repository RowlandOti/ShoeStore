package com.udacity.shoestore.data.model

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import kotlinx.android.parcel.Parcelize
import androidx.databinding.library.baseAdapters.BR

@Parcelize
data class Shoe(var _name: String, var _size: Double, var _company: String, var _description: String,
                var _images: List<String> = mutableListOf()) : Parcelable, BaseObservable() {

    var name: String
        @Bindable get() = _name
        set(value) {
            _name = value
            notifyPropertyChanged(BR.name)
        }

    var size: String
        @Bindable get() = _size.toString()
        set(value) {
            _size = value.toDouble()
            notifyPropertyChanged(BR.size)
        }

    var company: String
        @Bindable get() = _company
        set(value) {
            _company = value
            notifyPropertyChanged(BR.company)
        }

    var description: String
        @Bindable get() = _description
        set(value) {
            _description = value
            notifyPropertyChanged(BR.description)
        }

    var images: List<String>
        @Bindable get() = _images
        set(value) {
            _images = value
            notifyPropertyChanged(BR.images)
        }
}