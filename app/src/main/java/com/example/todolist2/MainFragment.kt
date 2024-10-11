package com.example.todolist2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainFragment : Fragment(), OnItemClickListener {

    private lateinit var itemListAdapter: ItemListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var sharedPreferences: SharedPreferences




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val value = arguments?.getInt("value")

        sharedPreferences = requireContext().getSharedPreferences("ToDoLiltPref", Context.MODE_PRIVATE)
        recyclerView = view.findViewById(R.id.itemList)
        itemListAdapter = ItemListAdapter(this)
        recyclerView.adapter = itemListAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        if (sharedPreferences.getString("result", null) == null) {
            val itemModelList = arrayListOf(ItemModel("name 1", "description 1"))
            val jsonResult = Gson().toJson(itemModelList)
            val editor = sharedPreferences.edit()
            editor.putString("result", jsonResult)
            editor.apply()
        }


//        addItems()

    }

    override fun onResume() {
        super.onResume()
        loadItemsFromPreferences()
    }


    private fun addItems() {
        val items = listOf(
            ItemModel("Task 1", "Description for task 1"),

        )
        items
            .filter { it.itemName.isNotEmpty() && it.itemDescription.isNotEmpty() }
            .forEach {
                itemListAdapter.addItem(it)
            }

    }

    /**
     * достать элементы itemName itemDesciption
     * проверить на не null
     * добавить в список (адаптер)
     * */
    private fun loadItemsFromPreferences() {
        val json = sharedPreferences.getString("result", null)
        if (json !=  null) {
            val gson = Gson()
            val type = object : TypeToken<ArrayList<ItemModel>>() {}.type
            val itemModelList: ArrayList<ItemModel> = gson.fromJson(json, type)
            val resultData = itemModelList
                .filter { it.itemName.isNotEmpty() && it.itemDescription.isNotEmpty() }
            itemListAdapter.replaceAll(resultData)
        }
    }

    override fun onItemClick(item: ItemModel) {
        // Переход на второй фрагмент
        val descriptionFragment = DescriptionFragment.newInstance(item)

        fragmentManager?.beginTransaction()
            ?.replace(R.id.activity_main_container, DescriptionFragment.newInstance(item))
            ?.addToBackStack(null)
            ?.commit()
    }


    companion object {
        fun newInstance(value: Int): MainFragment {
            val fragment = MainFragment()
            val bundle = bundleOf("value" to value)
            fragment.arguments = bundle
            return fragment
        }
    }


}