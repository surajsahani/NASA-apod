package com.martial.nasapod.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.martial.nasapod.databinding.RowImageBinding
import com.martial.nasapod.model.GalaxyUI
import com.martial.nasapod.utils.galaxyItemDiffCallback
import kotlinx.coroutines.NonCancellable.start


class ImagesAdapter(val onClick: (Int) -> Unit) :
    ListAdapter<GalaxyUI, ImagesAdapter.ImagesViewHolder>(galaxyItemDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val rowImageBinding =
            RowImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImagesViewHolder(rowImageBinding)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ImagesViewHolder(private val binding: RowImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(galaxyUI: GalaxyUI) {
//            binding.txtTitle.text = galaxyUI.title
            binding.imgGalaxy.contentDescription = galaxyUI.title
//            binding.txtCreatedOn.text = galaxyUI.createdOn
            val context = binding.imgGalaxy.context
            Glide.with(context)
                .load(galaxyUI.imageUrl).fitCenter().centerCrop()
                .placeholder(CircularProgressDrawable(context).apply {
                    strokeWidth = 5f
                    centerRadius = 30f
                    start()
                })
                //.error(R.drawable.ic_baseline_broken_image_24)
                .into(binding.imgGalaxy)

            itemView.setOnClickListener {
                onClick.invoke(layoutPosition)
            }
        }

    }
}