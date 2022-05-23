package com.d3if3116.hitung_luassegitiga.ui

import androidx.lifecycle.ViewModel
import com.d3if3116.hitung_luassegitiga.model.hasilLuas

class MainViewModel : ViewModel()  {

    fun luasHitung (Alas:Float, Tinggi:Float ): hasilLuas {
        val diameter = 0.5
        val luas = diameter * Alas * Tinggi
        return hasilLuas(luas)
    }
}