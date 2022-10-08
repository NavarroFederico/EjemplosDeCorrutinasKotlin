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
/*        val time = measureTimeMillis {
            runBlocking {
                for (i in 1..100_000) {
                    launch {
                        delay(10_000L)
                    }
                }
            }
        }
       Log.d(TAG,"tiempo transcurrido : $time en ${Thread.currentThread().name}")
*/
    val timeHiloMain = measureTimeMillis {
        for ( i in 1..10_000){
            Thread {
                Thread.sleep(1)
            }.run()
            }
        }
    Log.d(TAG,"tiempo transcurrido : $timeHiloMain en ${Thread.currentThread().name}")

    }

}

