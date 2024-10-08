package com.example.todolist2

import android.annotation.SuppressLint
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
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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

    @SuppressLint("SuspiciousIndentation")
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

    /**
     * достать элемент из EditText
     * достать сохраненный список из SharedPreferences
     * мы в этом списке ищем элемент по itemName, если его не нашли, то добавляем новый элемент в списке, если нашли, то обновляем описание
     * обновленный список сохраняем в sharedPreferences
     * */
    private fun saveToSharedPreference() {


        // достать элемент из EditText
        val name = binding.addTitle.text.toString()
        val description = binding.addDescription.text.toString()
        val model = ItemModel(name, description)

        //достать сохраненный список из SharedPreferences
        val json = sharedPreferences.getString("result", null)
        val gson = Gson()
        val type = object : TypeToken<ArrayList<ItemModel>>() {}.type
        val itemModelList: ArrayList<ItemModel> = gson.fromJson(json, type)

        // copy создает новый экземпляр класса с теми же параметрами
        // он тут нужен для того чтобы заменить описание, так как все параметры в классе у нас val

        // посмотреть самостоятельно на декмопил джавовский
        // мы в этом списке ищем элемент по itemName, если его не нашли, то добавляем новый элемент в списке, если нашли, то обновляем описание
        val index = itemModelList.indexOfFirst { it.itemName == model.itemName }
        if (index == -1) {
            itemModelList.add(model)
        } else {
            itemModelList[index] = itemModelList[index].copy(itemDescription = description)
        }

        // обновленный список сохраняем в sharedPreferences
        val jsonResult = Gson().toJson(itemModelList)
        val editor = sharedPreferences.edit()
        editor.putString("result", jsonResult)
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