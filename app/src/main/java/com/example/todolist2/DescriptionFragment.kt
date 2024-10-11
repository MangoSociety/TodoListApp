package com.example.todolist2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import com.example.todolist2.databinding.FragmentDescriptionBinding

class DescriptionFragment() : Fragment() {

    private lateinit var binding: FragmentDescriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemName = arguments?.getString("itemName")
        val itemDescription = arguments?.getString("itemDescription")

        binding.addTitle.setText(itemName)
        binding.addDescription.setText(itemDescription)

        view.findViewById<Button>(R.id.add_description_button).setOnClickListener {
            requireActivity().onBackPressed()
        }
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