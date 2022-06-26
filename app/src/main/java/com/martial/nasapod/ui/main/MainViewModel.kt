package com.martial.nasapod.ui.main


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.martial.nasapod.data.remote.ApodApi
import com.martial.nasapod.util.date.PictureDetailComparator

class MainViewModel @ViewModelInject constructor(apodApi: ApodApi) : ViewModel() {

  /**
   * Holds parsed images from Android resources
   */
  val images = apodApi.getImages().sortedWith(PictureDetailComparator)
}
