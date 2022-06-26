package com.martial.nasapod.home.detail

import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.martial.nasapod.databinding.RowDetailsBinding
import com.martial.nasapod.model.GalaxyUI
import com.martial.nasapod.utils.galaxyItemDiffCallback
import kotlinx.coroutines.NonCancellable.start

class ImageDetailsAdapter :
    ListAdapter<GalaxyUI, ImageDetailsAdapter.ImageDetailsViewHolder>(galaxyItemDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageDetailsViewHolder {
        val rowDetailsBinding =
            RowDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageDetailsViewHolder(rowDetailsBinding)
    }

    override fun onBindViewHolder(holder: ImageDetailsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ImageDetailsViewHolder(private val binding: RowDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(galaxyUI: GalaxyUI) {
            binding.txtTitle.text = galaxyUI.title
            binding.txtDescription?.text = galaxyUI.description
            binding.txtDescription?.movementMethod = ScrollingMovementMethod()
            binding.txtCopyright?.text = galaxyUI.copyrightBy
            binding.txtCreatedOn?.text = galaxyUI.createdOn
            binding.imgGalaxy.contentDescription = galaxyUI.title
            val context = binding.imgGalaxy.context
            Glide.with(context)
                .load(galaxyUI.hdImageUrl).fitCenter().centerCrop()
                .placeholder(CircularProgressDrawable(context).apply {
                    strokeWidth = 5f
                    centerRadius = 30f
                    start()
                })
                //.error(R.drawable.ic_baseline_broken_image_24)
                .into(binding.imgGalaxy)
        }

    }
}