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
    private lateinit var mediaPlayer: MediaPlayer
    private var pause:Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my, container, false)
        val btnNext: ImageButton = view.findViewById(R.id.btnnext)
        val playBtn: ImageButton = view.findViewById(R.id.btnPlay)
        val stopBtn: ImageButton = view.findViewById(R.id.btnStop)
        val seekbar: SeekBar = view.findViewById(R.id.seek_bar)
        playBtn.setOnClickListener {
            if (pause) {
                mediaPlayer.seekTo(mediaPlayer.currentPosition)
                mediaPlayer.start()
                pause = false
                Toast.makeText(this.context, "media playing", Toast.LENGTH_SHORT).show()
            } else {

                mediaPlayer =
                    MediaPlayer.create(this.context, Settings.System.DEFAULT_RINGTONE_URI)
                mediaPlayer.start()
                Toast.makeText(this.context, "media playing", Toast.LENGTH_SHORT).show()

            }

            playBtn.isEnabled = false
            stopBtn.isEnabled = true

            mediaPlayer.setOnCompletionListener {
                playBtn.isEnabled = true
                stopBtn.isEnabled = false
                Toast.makeText(this.context, "end", Toast.LENGTH_SHORT).show()
            }
        }
        // Pause the media player

        // Stop the media player
        stopBtn.setOnClickListener {
            if (mediaPlayer.isPlaying || pause.equals(true)) {
                pause = false
                seekbar.setProgress(0)
                mediaPlayer.stop()
                mediaPlayer.reset()
                mediaPlayer.release()

                playBtn.isEnabled = true
                stopBtn.isEnabled = false
                Toast.makeText(this.context, "media stop", Toast.LENGTH_SHORT).show()
            }
        }
        // Seek bar change listener
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    mediaPlayer.seekTo(i * 1000)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })





        return inflater.inflate(R.layout.fragment_my, container, false)
    }

            }
