package com.example.imageuploader

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.databinding.EachItemBinding
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ImagesAdapterOrigin(private var mList:List<String>) :
    RecyclerView.Adapter<ImagesAdapterOrigin.ImagesViewHolder>() {

    inner class ImagesViewHolder(var binding: EachItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val binding = EachItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImagesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        with(holder.binding) {
            with(mList[position]){
                Picasso.get().load(this).into(imageView)
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}