package com.d3if3116.hitung_luassegitiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Display
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.d3if3116.hitung_luassegitiga.databinding.ActivityMainBinding
import com.d3if3116.hitung_luassegitiga.model.hasilLuas

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater())
        setContentView(binding.root)

        binding.buttonHitung.setOnClickListener { HitungLuas() }
        binding.buttonReset.setOnClickListener{ resetButton () }

    }

    private fun HitungLuas() {

        val Alas = binding.alasInputNumber.text.toString()
        if (TextUtils.isEmpty(Alas)) {
            Toast.makeText(this, R.string.Alas_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val Tinggi = binding.tinggiInputNumber.text.toString()
        if (TextUtils.isEmpty(Tinggi)) {
            Toast.makeText(this, R.string.Tinggi_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val result = luasHitung(
            Alas.toFloat(),
            Tinggi.toFloat()
        )
        showResult(result)
    }

    private fun luasHitung(Alas:Float, Tinggi:Float ): hasilLuas {
        val diameter = 0.5
        val luas = diameter * Alas * Tinggi
        return hasilLuas(luas)
    }

    private fun showResult( result:hasilLuas){
        binding.hasilLuas.text = getString(R.string.hasilLuas_X,  result.luas)

    }
    private fun resetButton(){

        binding.alasInputNumber.setText("")
        binding.tinggiInputNumber.setText("")
        binding.hasilLuas.setText("")
    }


}


