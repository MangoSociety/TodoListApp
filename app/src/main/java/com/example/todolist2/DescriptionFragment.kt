package com.example.todolist2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf

class DescriptionFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_description, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemName = arguments?.getString("item name")
        val itemDescription = arguments?.getString("item description")

        view.findViewById<TextView>(R.id.addTitle).text = itemName
        view.findViewById<TextView>(R.id.addDescription).text = itemDescription
    }


    companion object {
        fun newInstance(item: ItemModel): DescriptionFragment {
            val fragment = DescriptionFragment()
            val bundle = bundleOf(
                "itemName" to item.itemName,
                "itemDescription" to item.itemDescription
            )
            fragment.arguments = bundle
            return fragment
        }


    }


}