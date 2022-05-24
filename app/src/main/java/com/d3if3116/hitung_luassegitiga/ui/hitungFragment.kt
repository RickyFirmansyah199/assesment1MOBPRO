package com.d3if3116.hitung_luassegitiga.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
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
        binding.historyButton.setOnClickListener{
            it.findNavController().navigate(
                R.id.action_hitungFragment_to_historyFragment
            )
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about) {
            findNavController().navigate(
                R.id.action_hitungFragment_to_aboutFragment2)
            return true
        }


        return super.onOptionsItemSelected(item)

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


