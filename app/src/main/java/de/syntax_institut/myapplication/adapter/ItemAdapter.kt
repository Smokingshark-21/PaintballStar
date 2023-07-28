package de.syntax_institut.myapplication.adapter

import android.content.Context
import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntax_institut.myapplication.MainActivity
import de.syntax_institut.myapplication.data.WareDatasource
import de.syntax_institut.myapplication.data.model.Wareitem
import de.syntax_institut.myapplication.data.model.item
import de.syntax_institut.myapplication.databinding.ListItemBinding
import de.syntax_institut.myapplication.util.OnlistChanedlistener

class ItemAdapter(
    private val context:Context,
    private val dataset: MutableList<item>,
    private val cart :MutableList<Wareitem>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    private var onlistChanedListener:OnlistChanedlistener?=null
    fun setonlistchaendlistener(listener:OnlistChanedlistener){
        this.onlistChanedListener=listener
    }

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

        holder.binding.itemnumberET.text

        holder.binding.addBTN.setOnClickListener {
            Log.d("testfun","import")
            cart.add(Wareitem(holder.binding.itemnumberET.text.toString(),context.resources.getString(item.textResource)))
            onlistChanedListener?.onListChanged()


        }

    }
}