package com.martial.nasapod.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.martial.nasapod.datasource.ApodRepository
import com.martial.nasapod.datasource.Resource
import com.martial.nasapod.model.GalaxyUI
import com.martial.nasapod.model.toGalaxyUI

class HomeViewModel(private val apodRepository: ApodRepository) : ViewModel() {

    private val _galaxyUI = MutableLiveData<Resource<List<GalaxyUI>>>()

    val galaxyUI: LiveData<Resource<List<GalaxyUI>>>
        get() = _galaxyUI

    fun fetchGalaxyImages() {
        _galaxyUI.value = Resource.Loading()
        val fetchImages = apodRepository.fetchImages()
        _galaxyUI.value = when (fetchImages) {
            is Resource.Loading -> Resource.Loading()
            is Resource.Success -> Resource.Success(fetchImages.data.map { it.toGalaxyUI() })
            is Resource.Failure -> Resource.Failure(fetchImages.throwable)
        }
    }

    private val _selectedItemPosition = MutableLiveData<Int>()

    val selectedItemPosition: LiveData<Int>
        get() = _selectedItemPosition

    fun setItemSelectedPosition(position: Int) {
        _selectedItemPosition.value = position
    }
}