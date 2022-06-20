package com.d3if3116.hitung_luassegitiga.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if3116.hitung_luassegitiga.model.Glossarium
import com.d3if3116.hitung_luassegitiga.network.ApiStatus
import com.d3if3116.hitung_luassegitiga.network.Segi3Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    private val data = MutableLiveData<List<Glossarium>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()

    }

    fun getData(): LiveData<List<Glossarium>> = data



    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(Segi3Api.service.getSegi3())
                status.postValue(ApiStatus.SUCCESS)

            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)

            }
        }
    }

    fun getStatus(): LiveData<ApiStatus> = status
}