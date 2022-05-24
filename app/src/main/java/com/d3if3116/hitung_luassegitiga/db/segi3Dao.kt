package com.d3if3116.hitung_luassegitiga.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface segi3Dao {

    @Insert
    fun insert(bmi: Segi3Entity)
    @Query("SELECT * FROM luas_segi3 ORDER BY id DESC LIMIT 1")
    fun getLastBmi(): LiveData<Segi3Entity?>
}