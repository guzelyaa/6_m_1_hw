package com.example.a6m1hw.ui.playlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.util.Util
import com.example.a6m1hw.databinding.ItemPlaylistBinding
import com.example.a6m1hw.model.Item
import com.example.a6m1hw.model.Playlist
import com.example.a6m1hw.utils.loadImage

class PlaylistAdapter(private val onClick: (String) -> Unit) :
    RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    private val data: ArrayList<Item> = arrayListOf()

    fun addData(newData: List<Item>?) {
        data.clear()
        if (newData != null) {
            data.addAll(newData)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class PlaylistViewHolder(val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {

            itemView.setOnClickListener {
                onClick(item.id.toString())
            }

            var count = item.contentDetails?.itemCount
            var title = item.snippet?.title
            binding.tvVideoCount.text = "$count video series"
            binding.tvTitle.text = item.snippet?.channelTitle
            binding.tvDesc.text = title.toString()
            binding.ivVideo.loadImage(item.snippet?.thumbnails?.default?.url.toString())
        }

    }
}