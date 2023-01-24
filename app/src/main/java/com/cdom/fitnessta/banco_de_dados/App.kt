package com.cdom.fitnessta.banco_de_dados

import android.app.Application
import com.cdom.fitnessta.banco_de_dados.BancoDeDadosApp

class App: Application() {

    lateinit var bancoDeDados: BancoDeDadosApp

    override fun onCreate() {
        super.onCreate()
        bancoDeDados = BancoDeDadosApp.criarBancoDeDados(this)
    }
}