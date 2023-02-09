package com.example.apicalls.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicalls.R
import com.example.apicalls.data.model.GotCharacter

class GotAdapter(

) : RecyclerView.Adapter<GotAdapter.ItemViewHolder>() {
    var dataset = listOf<GotCharacter>()

    // IDEE EINES VIEWHOLDERS
    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.got_name_text)
        val family: TextView = view.findViewById(R.id.got_family_text)
        val title: TextView = view.findViewById(R.id.got_title_text)

    }
    // Dataset wird nicht erkannt.
    fun submitList(newList: List<GotCharacter>) {
        dataset = newList
        notifyDataSetChanged()
    }

    // ERSTELLEN DES VIEWHOLDERS
    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.got_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    // BEFÜLLEN DES VIEWHOLDERS
    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val character = dataset[position]

        holder.name.text = character.fullName
        holder.family.text = character.family
        holder.title.text = character.title

    }
}