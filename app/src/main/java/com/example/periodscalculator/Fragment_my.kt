package com.example.periodscalculator

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.lang.reflect.Array.get


class Music : Fragment() {

/**/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)
        val btnNext: ImageButton = view.findViewById(R.id.btnnext)
        val playBtn: ImageButton = view.findViewById(R.id.btnPlay)
        val stopBtn: ImageButton = view.findViewById(R.id.btnStop)
        val seekbar: SeekBar = view.findViewById(R.id.seek_bar)
        val mp:MediaPlayer=MediaPlayer.create(view.context.applicationContext,Settings.System.DEFAULT_RINGTONE_URI)
        playBtn.setOnClickListener {
          if(!mp.isPlaying)
            {
                mp.start()
            }
            else
            {
                mp.pause()
            }
            Toast.makeText(activity?.applicationContext,"Youu just clicked on play btn",Toast.LENGTH_LONG)
        }
        return view
    }

            }
