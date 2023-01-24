package com.cdom.fitnessta.recy_view_lista_medidas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cdom.fitnessta.R
import com.cdom.fitnessta.databinding.ItemListaBinding
import com.cdom.fitnessta.recy_view_main_act.model.Calc
import java.text.SimpleDateFormat
import java.util.*

class AdapterLista(
    private val listaMedidas: List<Calc>
) : RecyclerView.Adapter<AdapterLista.VHolder>() {

    inner class VHolder(
        private val binding: ItemListaBinding
        ): RecyclerView.ViewHolder(binding.root) {

        fun especificar(itemEspecifico: Calc){
            val medida = binding.texto
            val resposta = itemEspecifico.resposta
            val formatadorData = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR"))
            val data = formatadorData.format(itemEspecifico.data)

            medida.text = getString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val layInflater = LayoutInflater.from(parent.context)
        val view = ItemListaBinding.inflate(layInflater, parent, false)

        return VHolder(view)
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        val itemEspecifico = listaMedidas[position]

        holder.especificar(itemEspecifico)
    }

    override fun getItemCount(): Int {
        return listaMedidas.size
    }


}