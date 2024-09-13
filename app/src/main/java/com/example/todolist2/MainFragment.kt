package com.example.todolist2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainFragment : Fragment(), OnItemClickListener {

    private lateinit var itemListAdapter: ItemListAdapter
    private lateinit var recyclerView: RecyclerView


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

        recyclerView = view.findViewById(R.id.itemList)
        itemListAdapter = ItemListAdapter(this)
        recyclerView.adapter = itemListAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        addItems()

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