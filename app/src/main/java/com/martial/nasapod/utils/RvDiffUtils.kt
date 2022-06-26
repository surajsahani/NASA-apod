package com.martial.nasapod.utils

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.martial.nasapod.model.GalaxyUI

val galaxyItemDiffCallback = ItemDiffCallback<GalaxyUI>()

class ItemDiffCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")  // equals() is OK for data classes
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}