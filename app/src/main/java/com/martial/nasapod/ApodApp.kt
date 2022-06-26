package com.martial.nasapod

import android.app.Application
import com.martial.nasapod.datasource.ApodRepository
import com.martial.nasapod.datasource.AssetResource
import com.martial.nasapod.datasource.createApodRepository
import com.martial.nasapod.datasource.createAssetResource
import com.martial.nasapod.home.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module


class ApodApp : Application() {
    override fun onCreate() {
        super.onCreate()
        //Timber.plant(Timber.DebugTree())

        // Start Koin
        startKoin {
            // androidLogger()
            androidContext(this@ApodApp)
            modules(appModule, appViewModel)
        }
    }
}

val appModule = module {

    single<AssetResource> {
        createAssetResource(androidContext())
    }

    single<ApodRepository> {
        createApodRepository(get())
    }
}

val appViewModel = module {

    viewModel {
        HomeViewModel(get())
    }
}