package com.martial.nasapod.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.martial.nasapod.R
import com.martial.nasapod.data.model.PictureDetail
import com.martial.nasapod.databinding.PictureDetailViewBinding


class PictureDetailAdapter(
  private val items: List<PictureDetail>,
) : RecyclerView.Adapter<PictureDetailAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = PictureDetailViewBinding.inflate(inflater, parent, false)
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(items[position])
  }

  override fun getItemCount(): Int {
    return items.size
  }

  class ViewHolder(
    private val binding: PictureDetailViewBinding,
  ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(picture: PictureDetail) {
      with(binding) {
        detailImage.load(picture.hdUrl) {
          crossfade(true)
          placeholder(R.drawable.placeholder)
        }
        if (picture.copyright != null) {
          detailCopyright.isVisible = true
          detailCopyright.text = "© ${picture.copyright}"
        }
        detailDate.text = picture.date
        detailTitle.text = picture.title
        detailExplanation.text = picture.explanation
      }
    }
  }
}
