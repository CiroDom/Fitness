package com.cdom.fitnessta.banco_de_dados

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.cdom.fitnessta.recy_view_main_act.model.Calc

@Database(entities = [Calc::class], version = 1)
@TypeConverters(ConversorDeData::class)
abstract class BancoDeDadosApp: RoomDatabase() {
    abstract fun fornecerDAO() : DAO

    companion object{
        private var INSTANCIA: BancoDeDadosApp? = null

        fun criarBancoDeDados(contexto: Context): BancoDeDadosApp {
            return if (INSTANCIA == null){
                synchronized(this){
                    INSTANCIA = Room.databaseBuilder(
                        contexto.applicationContext,
                        BancoDeDadosApp::class.java,
                        "FitnessApp_BDA"
                    ).build()
                }
                INSTANCIA as BancoDeDadosApp
            } else {
                INSTANCIA as BancoDeDadosApp
            }
        }
    }
}