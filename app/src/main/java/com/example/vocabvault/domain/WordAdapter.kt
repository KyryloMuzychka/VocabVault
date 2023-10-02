package com.example.vocabvault.domain

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.vocabvault.R

class WordAdapter(context: Context, resource: Int, objects: List<Word>) :
    ArrayAdapter<Word>(context, resource, objects) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.list_item_layout, parent, false)

        val mainText = itemView.findViewById<TextView>(R.id.mainText)
        val subText = itemView.findViewById<TextView>(R.id.subText)

        val word = getItem(position)

        mainText.text = word?.originalWord
        subText.text = word?.translatedWord

        return itemView
    }
}
