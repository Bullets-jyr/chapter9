package kr.co.bullets.chapter9

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.bullets.chapter9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private var mediaPlayer: MediaPlayer? = null

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
//        mediaPlayer?.pause()
        val intent = Intent(this, MediaPlayerService::class.java).apply {
            action = MEDIA_PLAYER_PAUSE
        }
        startService(intent)
    }

    private fun mediaPlayerPlay() {
        val intent = Intent(this, MediaPlayerService::class.java).apply {
            action = MEDIA_PLAYER_PLAY
        }
        startService(intent)

//        if (mediaPlayer == null) {
//            mediaPlayer = MediaPlayer.create(this, R.raw.cheer).apply {
//                isLooping = true
//            }
//        }
//        mediaPlayer?.start()
    }

    private fun mediaPlayerStop() {
//        mediaPlayer?.stop()
//        mediaPlayer?.release()
//        mediaPlayer = null
        val intent = Intent(this, MediaPlayerService::class.java).apply {
            action = MEDIA_PLAYER_STOP
        }
        startService(intent)
    }

    override fun onDestroy() {
        stopService(Intent(this, MediaPlayerService::class.java))
        super.onDestroy()
    }
}