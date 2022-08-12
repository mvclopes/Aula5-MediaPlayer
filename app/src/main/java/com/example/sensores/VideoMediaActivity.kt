package com.example.sensores

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.core.view.isVisible
import com.example.sensores.databinding.ActivityVideoMediaBinding

class VideoMediaActivity : AppCompatActivity() {

    private val binding: ActivityVideoMediaBinding by lazy { ActivityVideoMediaBinding.inflate(layoutInflater) }
    private val urlPath = "https://archive.org/download/WildlifeSampleVideo/Wildlife.mp4"
    private var uri = Uri.parse(urlPath)
    private var isContinuously = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.videoView)
        with(binding) {
            videoView.setOnCompletionListener {
                if (isContinuously) binding.videoView.start()
            }
            btnStop.setOnClickListener { binding.videoView.pause() }
            btnPlay.setOnClickListener { binding.videoView.start() }
            btnOnce.setOnClickListener {
                isContinuously = false
                progressBar.isVisible = true
                videoView.setMediaController(mediaController)
                videoView.setVideoURI(uri)
                videoView.requestFocus()
                videoView.start()
            }
            btnContinue.setOnClickListener {
                isContinuously = true
                progressBar.isVisible = true
                videoView.setMediaController(mediaController)
                videoView.setVideoURI(uri)
                videoView.requestFocus()
                videoView.start()
            }
            videoView.setOnPreparedListener { progressBar.isVisible = true }
        }

    }
}