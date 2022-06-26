package com.martial.nasapod.injection.module

import com.martial.nasapod.data.model.PictureDetail
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object MoshiModule {
  @Provides
  fun provideMoshi(): Moshi {
    return Moshi.Builder().build()
  }

  @Provides
  fun provideJsonAdapterForPictureDetailList(moshi: Lazy<Moshi>): JsonAdapter<List<PictureDetail>> {
    val listOfPicturesType = Types.newParameterizedType(List::class.java, PictureDetail::class.java)
    return moshi.get().adapter<List<PictureDetail>>(listOfPicturesType).failOnUnknown()
  }
}
