package br.com.santanderapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.santanderapp.R
import br.com.santanderapp.data.Conta
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    //Criação da tela.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Mostre a Toolbar.
        setSupportActionBar(findViewById(R.id.toolbar))

        //Iniciar os dados mocados da MainViewModel na MainActivity.
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()

        //Iniciar o Toast.
        val toastPagar = findViewById<MaterialCardView>(R.id.mcv_pagar)

        toastPagar.setOnClickListener {
           Toast.makeText(this, "Pagar", Toast.LENGTH_SHORT).show()
        }

        val toastTransferir = findViewById<MaterialCardView>(R.id.mcv_transferir)

        toastTransferir.setOnClickListener {
           Toast.makeText(this, "Transferir", Toast.LENGTH_SHORT).show()
        }

        val toastRecarregar = findViewById<MaterialCardView>(R.id.mcv_recarregar)

        toastRecarregar.setOnClickListener {
           Toast.makeText(this, "Recarregar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(conta: Conta) {
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.tv_agencia).text = conta.agencia
        findViewById<TextView>(R.id.tv_conta_corrente).text = conta.numero
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
        findViewById<TextView>(R.id.tv_resultado_saldo_limite).text = conta.limite
        findViewById<TextView>(R.id.tv_cartao_final_value).text = conta.cartao.numero_cartao
    }

    //Iniciar o Menu na toolbar, ao selecionar o Menu.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    //Escutar o item do Menu sendo selecionado.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                //Mostrar o que está acontecendo no Log do Android Studio.
                Log.d("CLICK", "Click no item 1")
                true
                //Caso não seja selecionado nenhum item, volte para o Menu
            } else -> super.onOptionsItemSelected(item)
        }
    }
}