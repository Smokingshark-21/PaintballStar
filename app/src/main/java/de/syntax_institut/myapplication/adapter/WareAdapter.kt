package de.syntax_institut.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.myapplication.data.model.Wareitem
import de.syntax_institut.myapplication.databinding.WarenItemBinding
import de.syntax_institut.myapplication.util.OnlistChanedlistener

class WareAdapter(
    private val dataset:MutableList<Wareitem>

): RecyclerView.Adapter<WareAdapter.ItemViewHolder>() ,OnlistChanedlistener{

    inner class ItemViewHolder(val binding: WarenItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = WarenItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.wareTV.text = item.stringResources
        holder.binding.wareanzahlTV.text = item.anzahl
        holder.binding.wareremoveBTN.setOnClickListener {
            dataset.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onListChanged() {
        notifyDataSetChanged()
    }

}