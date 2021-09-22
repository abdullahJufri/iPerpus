package com.dicoding.iperpus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListBookAdapter(val listBook: ArrayList<Book>) : RecyclerView.Adapter<ListBookAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_book, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val book = listBook[position]
        Glide.with(holder.itemView.context)
            .load(book.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = book.name
        holder.tvDetail.text = book.detail
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }
}