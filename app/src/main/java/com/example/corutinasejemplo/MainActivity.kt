package com.example.corutinasejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG: String = ("ActividadPrincipal")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val job = GlobalScope.launch {
            Log.d(TAG, "Corrutina Iniciada")
            delay(5000)
            Log.d(TAG, "Corrutina Finalizada")

        }

        btn_ejecutar.setOnClickListener {
            job.cancel()
            Log.d(TAG, "Corrutina cancelada")

        }

//el async nos devuelve una promesa , que la corrutina nos va a devolver un valor ...
        GlobalScope.async {
            val suma1 = async {
                suma(1,5)

            }
            val suma2 = async {
                suma(10,5)
            }
            val total = suma(suma1.await(),suma2.await())
            Log.d(TAG, "$total")
        }

    }

    private fun suma(num1: Int, num2: Int ) = num1 + num2
}