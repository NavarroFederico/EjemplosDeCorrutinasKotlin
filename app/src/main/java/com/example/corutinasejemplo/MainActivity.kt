package com.example.corutinasejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private val TAG: String = "ActividadPrincipal"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Funcion main fue iniciada  ${Thread.currentThread().name}")



        btn_ejecutar.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {

                Log.d(TAG, "Corrutina 1 Iniciada ${Thread.currentThread().name}")
                obtenerInfoDeInternet()
                Log.d(TAG, "Corrutina 1 Finalizada")
            }
            GlobalScope.launch(Dispatchers.Main) {
                Log.d(TAG, "Corrutina 2 Iniciada ${Thread.currentThread().name}")
                textView.setText("esperando")
                Log.d(TAG, "Corrutina 2 Finalizada")
            }
        }

        // Log.d(TAG,respuesta)

    }


    suspend fun obtenerInfoDeInternet(): String {
        Log.d(TAG,"Obteniendo respuesta ${Thread.currentThread().name}")
        delay(5000L)
        textView.setText("Respuesta De Internet")
        return "Respuesta de Internet"
    }
}


