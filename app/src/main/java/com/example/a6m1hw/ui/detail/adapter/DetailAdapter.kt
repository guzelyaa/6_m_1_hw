package com.example.a6m1hw.ui.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.util.Util
import com.example.a6m1hw.R
import com.example.a6m1hw.databinding.ItemDetailBinding
import com.example.a6m1hw.databinding.ItemPlaylistBinding
import com.example.a6m1hw.model.Item
import com.example.a6m1hw.model.Playlist
import com.example.a6m1hw.utils.loadImage

class DetailAdapter(private val onClick: (Item) -> Unit, private val context: Context) :
    RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    private val data: ArrayList<Item> = arrayListOf()

    fun addData(newData: List<Item>?) {
        data.clear()
        if (newData != null) {
            data.addAll(newData)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            ItemDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class DetailViewHolder(val binding: ItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {

            itemView.setOnClickListener {
                onClick(item)
            }

            val count = item.contentDetails?.itemCount
            val title = item.snippet?.title
            binding.tvVideoCount.text = context.getString(R.string.video_count, count)
//            binding.tvTitle.text = item.snippet?.channelTitle
            binding.tvDesc.text = title.toString()
            binding.ivVideo.loadImage(item.snippet?.thumbnails?.default?.url.toString())
        }

    }
}