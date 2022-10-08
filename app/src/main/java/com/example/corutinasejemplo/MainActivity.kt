package com.example.corutinasejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private val TAG: String = "ActividadPrincipal"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Corriendo corrutina
        Log.d(TAG, "Corriendo código 2 en el subproceso : ${Thread.currentThread().name}")
        Log.d(TAG, "Hola, ")
        GlobalScope.launch {
            Log.d(TAG, "Corriendo corrutina en el subproceso: ${Thread.currentThread().name}")
            delay(5000L)
            Log.d(TAG, "Mundo")
        }
        Log.d(TAG, "Federico en : ${Thread.currentThread().name}")
    }

}


