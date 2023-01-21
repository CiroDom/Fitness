package com.cdom.fitnessta

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cdom.fitnessta.databinding.ItemMainBinding

class Adapter(
    private val listaItens: List<ItemMain>,
    private val ClickListenerDoItem: (id: Int) -> Unit
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun especificar(itemEspecifico: ItemMain){
            val img = binding.imgIcone
            val nome = binding.txtNome
            val container = binding.container

            img.setImageResource(itemEspecifico.drawableId)
            nome.setText(itemEspecifico.txtStringId)
            container.setBackgroundColor(itemEspecifico.color)

            container.setOnClickListener{
                ClickListenerDoItem(itemEspecifico.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val layInflater = LayoutInflater.from(parent.context)
        val view = ItemMainBinding.inflate(layInflater, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemEspecifico =listaItens[position]

        holder.especificar(itemEspecifico)
    }

    override fun getItemCount(): Int {
        return listaItens.size
    }

}