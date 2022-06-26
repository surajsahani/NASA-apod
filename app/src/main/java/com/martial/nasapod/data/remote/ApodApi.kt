package com.martial.nasapod.data.remote

import com.martial.nasapod.data.model.PictureDetail


interface ApodApi {
  fun getImages(): List<PictureDetail>
}
