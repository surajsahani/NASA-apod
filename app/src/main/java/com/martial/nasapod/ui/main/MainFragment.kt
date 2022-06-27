package com.martial.nasapod.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.martial.nasapod.R
import com.martial.nasapod.databinding.MainFragmentBinding
import com.martial.nasapod.util.fragment.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {
  private val viewModel: MainViewModel by activityViewModels()
  private val binding by viewBinding(MainFragmentBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    val navController = findNavController()
    val adapter = ApodImagesAdapter(viewModel.images) { position ->
      navController.navigate(MainFragmentDirections.toDetailFragment(position))
    }
    val layoutManager = GridLayoutManager(requireContext(), 2)
    binding.apodRecyclerView.layoutManager = layoutManager
    binding.apodRecyclerView.adapter = adapter
  }

  fun add() {

  }

}
