package com.example.periodscalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.lang.Runnable
import androidx.appcompat.widget.AppCompatButton

class MainActivity2 : AppCompatActivity() {
    private lateinit var handler: Handler
    private lateinit var runnable:Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent= Intent(this,MainActivity::class.java)
        handler= Handler()
        runnable=Runnable {
            startActivity(intent)
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
        }
    }
