package com.example.labexample

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_custom_widget.*

class CustomWidgetActivity : AppCompatActivity() {

    var mediaPlayer:MediaPlayer ?= null         //volume은 0~1 사이의 값을 가진다.
    var vol = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_widget)
        init()
    }

    fun init() {
        imageView.setVolumeListener(object :VolumeControlView.VolumeListener{
            override fun onChanged(angle: Float) {
                vol = if(angle > 0){
                    angle/360
                }else{
                    (360 + angle)/360
                }
                mediaPlayer?.setVolume(vol, vol)
            }
        })

        startBtn.setOnClickListener{
            if(mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.song)
                mediaPlayer?.setVolume(vol, vol)
            }
            mediaPlayer?.start()
        }

        pauseBtn.setOnClickListener {
            mediaPlayer?.pause()
        }

        stopBtn.setOnClickListener{
            mediaPlayer?.stop()
            mediaPlayer?.release()      //음악 재생 메모리 해제
            mediaPlayer = null          //메모리 해제 후 null로 초기화
        }

    }
}
