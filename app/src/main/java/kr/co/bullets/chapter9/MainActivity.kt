package kr.co.bullets.chapter9

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.bullets.chapter9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pauseButton.setOnClickListener {
            mediaPlayerPause()
        }

        binding.playButton.setOnClickListener {
            mediaPlayerPlay()
        }

        binding.stopButton.setOnClickListener {
            mediaPlayerStop()
        }
    }

    private fun mediaPlayerPause() {
        mediaPlayer?.pause()
    }

    private fun mediaPlayerPlay() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.cheer).apply {
                isLooping = true
            }
        }
        mediaPlayer?.start()
    }

    private fun mediaPlayerStop() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}