package com.example.corutinasejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
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


    }
}