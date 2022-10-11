package com.example.corutinasejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private val TAG: String = "ActividadPrincipal"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Funcion main fue iniciada  ${Thread.currentThread().name}")



        btn_ejecutar.setOnClickListener {

            GlobalScope.launch(Dispatchers.IO) {
                val tiempo = measureTimeMillis {
                    val job1 = async { obtenerInfoDeInternet(1) }
                    val job2 = async { obtenerInfoDeInternet(2) }

                    Log.d(TAG, job1.await())
                    Log.d(TAG, job2.await())

                    withContext(Dispatchers.Main) {
                        Log.d(TAG,"Se muestra la respuesta en text vie pantalla ${Thread.currentThread().name}")
                        textView.text =  job1.await()+job2.await() +"Ambas respuestas en un tiempo de "
                    }
                }
                Log.d(TAG,"$tiempo")//estaria bueno enviar esto al textview
            }

        }
    }

    suspend fun obtenerInfoDeInternet(num: Int): String {
        Log.d(TAG, "Obteniendo respuesta ${Thread.currentThread().name}")
        delay(3000L)
        Log.d(TAG, "Se obtuvo ${Thread.currentThread().name}")
        return "Respuesta de Internet $num"

    }
}
