package com.mehedi.inspections.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mehedi.inspections.R
import com.mehedi.inspections.databinding.ItemImageSlideBinding

class ImageAdapter(
    private val imageList: List<String>
) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(val binding: ItemImageSlideBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {

        return ImageViewHolder(
            ItemImageSlideBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(imageList[position])
            .placeholder(R.drawable.img_placeholder).into(holder.binding.imageView)

    }

    override fun getItemCount(): Int {
        return imageList.size
    }


}