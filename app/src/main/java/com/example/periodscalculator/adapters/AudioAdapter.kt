package com.example.periodscalculator.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.periodscalculator.MainActivity
import com.example.periodscalculator.R
import com.example.periodscalculator.audioList

internal class AudioAdapter(private var songName:List<String>):RecyclerView.Adapter<AudioAdapter.MyViewHolder>(){
    internal inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        var AudioTitle:TextView=view.findViewById(R.id.AudioTitle)
        var btnPlay:ImageButton=view.findViewById(R.id.imageButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item=songName[position]
        holder.AudioTitle.text=item
        holder.btnPlay.setOnClickListener {
            val ctx=audioList().applicationContext
            val intent=Intent(ctx,MainActivity::class.java)
        }
    }

    override fun getItemCount(): Int {
        return songName.size
    }
}