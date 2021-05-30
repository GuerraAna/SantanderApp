package br.com.santanderapp.data.local

import br.com.santanderapp.data.Cartao
import br.com.santanderapp.data.Cliente
import br.com.santanderapp.data.Conta

class FakeData {
    fun getLocaData(): Conta {
        val cartao = Cartao(
            numero_cartao = "123123123"
        )
        val cliente = Cliente(
            nome = "Ana Clara"
        )
        return Conta(
            numero = "445655-5",
            agencia = "6552-4",
            saldo = "R$ 22.450,80",
            limite = "R$ 4.200,00",
            cliente,
            cartao
        )
    }
}