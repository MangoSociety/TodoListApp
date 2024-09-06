package com.example.todolist2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val topicText: TextView = itemView.findViewById(R.id.topicText)
    private val topicTitle: TextView = itemView.findViewById(R.id.topicTitle)


    fun bind(itemModel: ItemModel) {
        topicTitle.text = itemModel.itemName ?: "no name"
        topicText.text = itemModel.itemDescription ?: "no description"
    }

}
