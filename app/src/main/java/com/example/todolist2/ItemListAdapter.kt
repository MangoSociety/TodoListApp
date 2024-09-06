package com.example.todolist2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemListAdapter:RecyclerView.Adapter<ItemListViewHolder>() {

    val itemList = mutableListOf<ItemModel>()

    fun addItem(itemModel: ItemModel) {
        // Проверка на пустое значение
        if (itemModel.itemName.isNullOrEmpty() || itemModel.itemDescription.isNullOrEmpty()) {
            // Вы можете добавить обработку ошибки здесь, например, показать Toast или логировать ошибку
            return
        }
        // Добавление элемента в список и обновление RecyclerView
        itemList.add(itemModel)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_element, parent, false)

        return ItemListViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        holder.bind(itemList[position])

    }


}