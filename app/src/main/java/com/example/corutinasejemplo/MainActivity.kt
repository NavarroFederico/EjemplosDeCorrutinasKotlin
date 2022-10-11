package com.example.corutinasejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG: String = "ActividadPrincipal"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Funcion main fue iniciada  ${Thread.currentThread().name}")



        btn_ejecutar.setOnClickListener {

            GlobalScope.launch(Dispatchers.IO) {
                val respuesta = obtenerInfoDeInternet()
                withContext(Dispatchers.Main) {
                    Log.d(TAG, "Se muestra la respuesta en text vie pantalla ${Thread.currentThread().name}")
                textView.text = respuesta
                }
            }
        }
        // Log.d(TAG,respuesta)

    }


    suspend fun obtenerInfoDeInternet(): String {
        Log.d(TAG, "Obteniendo respuesta ${Thread.currentThread().name}")
        delay(3000L)

        return "Respuesta de Internet"

    }
}