package com.d3if3116.hitung_luassegitiga.ui.home

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.d3if3116.hitung_luassegitiga.R
import com.d3if3116.hitung_luassegitiga.databinding.FragmentHomeBinding
import com.d3if3116.hitung_luassegitiga.model.hasilLuas

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container, false)
        binding.buttonHitung.setOnClickListener { HitungLuas() }
        binding.buttonReset.setOnClickListener{ resetButton () }

        setHasOptionsMenu(true)
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


    private fun showResult( result: hasilLuas){
        binding.hasilLuas.text = getString(R.string.hasilLuas_X,  result.luas)

    }
    private fun resetButton(){

        binding.alasInputNumber.setText("")
        binding.tinggiInputNumber.setText("")
        binding.hasilLuas.setText("")
    }

}