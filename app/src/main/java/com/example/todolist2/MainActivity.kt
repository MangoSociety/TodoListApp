package com.example.todolist2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var itemListAdapter: ItemListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация RecyclerView и адаптера
        val recyclerView: RecyclerView = findViewById(R.id.itemList)
        itemListAdapter = ItemListAdapter()
        recyclerView.adapter = itemListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Добавляем тестовые элементы
        addTestItems()
    }

    private fun addTestItems() {
        itemListAdapter.addItem(ItemModel("Task 1", "Description for task 1"))
        itemListAdapter.addItem(ItemModel("Task 2", "Description for task 2"))
        // В дальнейшем можете вызывать этот метод для добавления новых элементов
    }
}
