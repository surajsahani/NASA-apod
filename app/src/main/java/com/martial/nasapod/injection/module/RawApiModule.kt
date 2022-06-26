package com.martial.nasapod.injection.module

import com.martial.nasapod.data.local.ApodLocalApi
import com.martial.nasapod.data.remote.ApodApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RawApiModule {
  @Binds
  abstract fun bindLocalApi(apodLocalApi: ApodLocalApi): ApodApi
}
