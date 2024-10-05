package com.example.todolist2

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import com.example.todolist2.databinding.FragmentDescriptionBinding

class DescriptionFragment : Fragment() {

    private lateinit var binding: FragmentDescriptionBinding
    private lateinit var sharedPreferences: SharedPreferences

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

        sharedPreferences = requireContext().getSharedPreferences("ToDoLiltPref", Context.MODE_PRIVATE)
        val saveTitle = sharedPreferences.getString("itmName", "")
        val saveDescription = sharedPreferences.getString("itemDescription", "")

        binding.addTitle.setText(saveTitle)
        binding.addDescription.setText(saveDescription)


        val itemName = arguments?.getString("itemName")
        val itemDescription = arguments?.getString("itemDescription")

        if (itemName != null)
        binding.addTitle.setText(itemName)

        if(itemDescription != null)
        binding.addDescription.setText(itemDescription)

        view.findViewById<Button>(R.id.add_description_button).setOnClickListener {
            saveToSharedPreference()
            requireActivity().onBackPressed()
        }
    }

    private fun saveToSharedPreference() {
        val editor = sharedPreferences.edit()
        editor.putString("itemName", binding.addTitle.text.toString())
        editor.putString("itemDescription",binding.addDescription.text.toString())
        editor.apply()
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