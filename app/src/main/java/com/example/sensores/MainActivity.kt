package com.example.sensores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sensores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding) {
            recuperarFotos.setOnClickListener { acessarAnimacao() }
            webView.setOnClickListener { acessarWebView() }
            audioManager.setOnClickListener { acessaSons() }
            mediaPlayer.setOnClickListener { acessaVideo() }
            viewAnimation.setOnClickListener { acessaAnimacoes() }
        }
    }

    private fun acessarAnimacao() {
        val intent = Intent(this, RecuperaFotosActivity::class.java)
        startActivity(intent)
    }

    private fun acessarWebView() {
        val intent = Intent(this, WebViewActivity::class.java)
        startActivity(intent)
    }

    private fun acessaSons() {
        val intent = Intent(this, SonsActivity::class.java)
        startActivity(intent)
    }

    private fun acessaVideo() {
        val intent = Intent(this, VideoMediaActivity::class.java)
        startActivity(intent)
    }

    private fun acessaAnimacoes() {
        val intent = Intent(this, AnimationsActivity::class.java)
        startActivity(intent)
    }
}