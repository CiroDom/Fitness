package com.cdom.fitnessta.banco_de_dados

import androidx.room.TypeConverter
import java.util.*

object ConversorDeData {
    @TypeConverter
    fun converterParaDate(dataEmLong: Long?): Date?{
        dataEmLong?.let {
            return Date(dataEmLong)
        }
        return null
    }

    @TypeConverter
    fun converterAPartirDaData(data: Date?): Long?{
        return Date().time
    }
}