package com.example.sensores

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sensores.databinding.ActivitySonsBinding

class SonsActivity : AppCompatActivity() {

    private val binding: ActivitySonsBinding by lazy { ActivitySonsBinding.inflate(layoutInflater) }

    // Criação das mídias de aúdio a partir de arquivos do package Raw
    private val som1: MediaPlayer by lazy { MediaPlayer.create(this, R.raw.mickey) }
    private val som2: MediaPlayer by lazy { MediaPlayer.create(this, R.raw.ronaldo) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // Configurando listener para escutar evento de clique nos botões
        with(binding) {
            som1.setOnClickListener { somMickey() }
            som2.setOnClickListener { somRonaldo() }
        }
    }

    // Métodos para inicialização dos aúdios
    private fun somMickey() = som1.start()
    private fun somRonaldo() = som2.start()
}