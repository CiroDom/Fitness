package com.cdom.fitnessta.recy_view_main_act.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Calc(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val tipo: String,
    @ColumnInfo
    val resposta: Double,
    @ColumnInfo
    val data: Date = Date()
)
