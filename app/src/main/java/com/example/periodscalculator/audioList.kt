package com.example.periodscalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.periodscalculator.adapters.AudioAdapter

class audioList : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
    private val AudioList=ArrayList<String>()
    private lateinit var audioAdapter:AudioAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_list)
        title="Audio Files"

        val recyclerView:RecyclerView=findViewById(R.id.recyclerview)
        audioAdapter= AudioAdapter(AudioList)
        val layoutManager= LinearLayoutManager(applicationContext)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=audioAdapter
        prepareItems()
        recyclerView.itemAnimator

    }

    private fun next(name:String){
        val intent= Intent(this,name::class.java)
        startActivity(intent)
    }
    private fun prepareItems() {
        AudioList.add("Item1")
        AudioList.add("Item2")
        audioAdapter.notifyDataSetChanged()
    }


}