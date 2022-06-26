package com.martial.nasapod.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.navigation.findNavController
import com.martial.nasapod.R
import com.martial.nasapod.databinding.ActivityMainBinding
import com.martial.nasapod.utils.safeNavigate
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber


class HomeActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)
        Timber.e("onCreate() called with: savedInstanceState = $savedInstanceState")


        homeViewModel.fetchGalaxyImages()

        homeViewModel.selectedItemPosition.observe(this) {
            Timber.e("Position $it")
            if (it != null) {
                findNavController(R.id.hostFragmentContainer).safeNavigate(
                    ImageListFragmentDirections.actionImageListFragmentToImageDetailsFragment()
                        .setSelectedPosition(it)

                )
            }
        }
    }
}