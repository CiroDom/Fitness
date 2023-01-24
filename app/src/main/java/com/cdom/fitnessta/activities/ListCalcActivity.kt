package com.cdom.fitnessta.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cdom.fitnessta.databinding.ActivityListCalcBinding
import com.cdom.fitnessta.banco_de_dados.App

class ListCalcActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityListCalcBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tipo = intent?.extras?.getString("tipo") ?: throw IllegalStateException("Tipo não encontrado")

        Thread {
            val app = application as App
            val dao = app.bancoDeDados.fornecerDAO()
            val resposta = dao.buscarRegistroPeloTipo(tipo)

            runOnUiThread {

            }
        }.start()
    }
}