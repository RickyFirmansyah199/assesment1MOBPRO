package com.d3if3116.hitung_luassegitiga.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.d3if3116.hitung_luassegitiga.R
import com.d3if3116.hitung_luassegitiga.databinding.FragmentHitungBinding
import com.d3if3116.hitung_luassegitiga.model.hasilLuas

class hitungFragment : Fragment() {
    private lateinit var binding: FragmentHitungBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentHitungBinding.inflate(layoutInflater,container, false)
        binding.buttonHitung.setOnClickListener { HitungLuas() }
        binding.buttonReset.setOnClickListener{ resetButton () }
        return binding.root
    }

    private fun HitungLuas() {

        val Alas = binding.alasInputNumber.text.toString()
        if (TextUtils.isEmpty(Alas)) {
            Toast.makeText(context, R.string.Alas_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val Tinggi = binding.tinggiInputNumber.text.toString()
        if (TextUtils.isEmpty(Tinggi)) {
            Toast.makeText(context, R.string.Tinggi_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val result = viewModel.luasHitung(
            Alas.toFloat(),
            Tinggi.toFloat()
        )
        showResult(result)
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


