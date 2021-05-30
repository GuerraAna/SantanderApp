package br.com.santanderapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.santanderapp.data.Conta
import br.com.santanderapp.data.local.FakeData

//ViewModel: pega os dados e joga para activity.

class MainViewModel:  ViewModel() {

    //MutableLiveData: Altera os dados observados, pela activity, no futuro.
    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente(): LiveData<Conta> {
        mutableLiveData.value = FakeData().getLocaData()

        return mutableLiveData
    }
}