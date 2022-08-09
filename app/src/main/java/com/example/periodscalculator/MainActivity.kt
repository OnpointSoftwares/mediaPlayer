package com.example.periodscalculator

import android.content.res.Resources
import android.media.MediaPlayer
import android.media.MediaPlayer.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.ImageButton
import android.widget.SeekBar
import android.content.Context
import android.net.Uri
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.periodscalculator.Adapter


class MainActivity : AppCompatActivity() {
   private lateinit var mp:MediaPlayer
   private lateinit var seekbar:SeekBar
   private lateinit var handler:Handler
    private lateinit var runnable:Runnable
    private lateinit var txtCurrentSong: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnNext: ImageButton = findViewById(R.id.btnnext)
        val playBtn: ImageButton = findViewById(R.id.btnPlay)
        val stopBtn: ImageButton = findViewById(R.id.btnStop)
        seekbar= findViewById(R.id.seek_bar)
        txtCurrentSong=findViewById(R.id.txtCurrentSong)
        txtCurrentSong.text="jina"
        playBtn.setOnClickListener {
            mp= MediaPlayer.create(applicationContext,R.raw.jina)
            if(!mp.isPlaying)
            {
                playBtn.setImageResource(R.drawable.ic_baseline_pause_24)
                mp.start()
                Toast.makeText(this,"started playing...",Toast.LENGTH_LONG).show()
            }
            else if(mp.isPlaying)
            {
                mp.seekTo(mp.currentPosition)
                mp.pause()

            }
            else{
                Toast.makeText(this,"error!!",Toast.LENGTH_LONG).show()
            }
            initializeSeekbar()
        }
        stopBtn.setOnClickListener {
            if(mp.isPlaying)
            {
                seekbar.setProgress(0)
                playBtn.setImageResource(R.drawable.ic_play)
                mp.stop()
            }
            else{
                Toast.makeText(this,"No song playing now...",Toast.LENGTH_LONG).show()
            }

        }
    }

    private fun initializeSeekbar() {
       seekbar.max=mp.duration/1000
        handler=Handler()
        runnable= Runnable {
            seekbar.progress=mp.currentPosition/1000
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}