package com.cdom.fitnessta.banco_de_dados

import androidx.room.*
import com.cdom.fitnessta.recy_view_main_act.model.Calc

@Dao
interface DAO {
    @Insert
    fun inserir(calc: Calc)
    @Delete
    fun deletar(calc: Calc)
    @Query("SELECT * FROM Calc WHERE tipo = :tipo")
    fun buscarRegistroPeloTipo(tipo: String): List<Calc>
}