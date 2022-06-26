package com.martial.nasapod.data.local

import android.content.Context
import com.martial.nasapod.R
import com.martial.nasapod.data.model.PictureDetail
import com.martial.nasapod.data.remote.ApodApi
import com.squareup.moshi.JsonAdapter
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class ApodLocalApi @Inject constructor(
  @ApplicationContext private val context: Context,
  private val jsonAdapter: JsonAdapter<List<PictureDetail>>,
): ApodApi {
  override fun getImages(): List<PictureDetail> {
    val resource = context.resources.openRawResource(R.raw.data)
    val string = resource.bufferedReader().use { it.readText() }
    return jsonAdapter.fromJson(string) ?: error("Failed to parse JSON data")
  }
}
