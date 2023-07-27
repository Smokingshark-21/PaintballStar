package de.syntax_institut.myapplication.adapter

import android.content.Context
import android.nfc.Tag
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.myapplication.data.model.item
import de.syntax_institut.myapplication.databinding.ListItemBinding

class ItemAdapter(
    private val context:Context,
    private val dataset: MutableList<item>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(val binding:ListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.itemIV.setImageResource(item.imageResource)
        holder.binding.itemTV.text = context.resources.getString(item.textResource)
        holder.binding.addBTN.setOnClickListener {
            item.anzahl++
            notifyDataSetChanged()

        }
        holder.binding.removeBTN.setOnClickListener {
            if (item.anzahl!=0){
            item.anzahl--
                notifyDataSetChanged()
            }
        }
        holder.binding.anzahlTV.text = item.anzahl.toString()
    }
}