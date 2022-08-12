package com.example.sensores

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.sensores.databinding.ActivityVideoMediaBinding

class VideoMediaActivity : AppCompatActivity() {

    private val binding: ActivityVideoMediaBinding by lazy { ActivityVideoMediaBinding.inflate(layoutInflater) }

    // Instância responsável pelo controle do Media Player
    private val mediaController: MediaController by lazy { MediaController(this) }

    // String contendo URL de vídeo
    private val urlPath = "https://archive.org/download/WildlifeSampleVideo/Wildlife.mp4"

    // Conversão da string da URL em URI
    private var uri = Uri.parse(urlPath)

    // Variável responsável por controlar se o vídeo irá se repetir
    private var isContinuously = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mediaController.setAnchorView(binding.videoView)

        with(binding) {
            onFinishVideo()
            onLoadedVideo()
            stopVideo()
            playVideo()
            uploadAndPlayVideo()
            setContinuouslyVideo()
        }

    }

    // Método que é executado após o vídeo já estar preparado para ser executado
    private fun ActivityVideoMediaBinding.onLoadedVideo() {
        videoView.setOnPreparedListener { progressBar.isVisible = false }
    }

    // Método que é executado na finalização do vídeo
    private fun ActivityVideoMediaBinding.onFinishVideo() {
        videoView.setOnCompletionListener { if (isContinuously) videoView.start() }
    }

    // Método responsável por carregar o vídeo e executá-lo posteriormente
    private fun ActivityVideoMediaBinding.uploadAndPlayVideo() {
        btnOnce.setOnClickListener {
            isContinuously = false
            progressBar.isVisible = true
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(uri)
            videoView.requestFocus()
            videoView.start()
        }
    }

    // Método responsável por configurar o vídeo com contínuo
    private fun ActivityVideoMediaBinding.setContinuouslyVideo() {
        btnContinuously.setOnClickListener { isContinuously = true }
    }

    // Método responsável por iniciar a execução do vídeo
    private fun ActivityVideoMediaBinding.playVideo() {
        btnPlay.setOnClickListener { videoView.start() }
    }

    // Método responsável por pausar o vídeo
    private fun ActivityVideoMediaBinding.stopVideo() {
        btnStop.setOnClickListener { binding.videoView.pause() }
    }
}