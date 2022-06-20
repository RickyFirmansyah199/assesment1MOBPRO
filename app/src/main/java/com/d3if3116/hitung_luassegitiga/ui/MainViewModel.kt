package com.d3if3116.hitung_luassegitiga.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if3116.hitung_luassegitiga.db.segi3Dao
import com.d3if3116.hitung_luassegitiga.model.hasilLuas
import com.d3if3116.hitung_luassegitiga.network.Segi3Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel()  {



    fun luasHitung (Alas:Float, Tinggi:Float ): hasilLuas {
        val diameter = 0.5
        val luas = diameter * Alas * Tinggi
        return hasilLuas(luas)
    }


}