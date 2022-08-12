package com.example.sensores

import android.annotation.SuppressLint
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.sensores.databinding.ActivityWebViewBinding

@SuppressLint("SetJavaScriptEnabled")
class WebViewActivity : AppCompatActivity() {

    private val binding: ActivityWebViewBinding by lazy { ActivityWebViewBinding.inflate(layoutInflater) }

    // URL do site a ser exibido na WebView
    private val url = "https://www.fiap.com.br/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            // Configuração do componente WebClient da view
            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    if (!url.isNullOrBlank()) {
                        view?.loadUrl(url)
                    }
                    return true
                }
            }
            // Habilita execução com JavaScript
            webView.settings.javaScriptEnabled = true
            // Carregamento da URL no componente WebView
            webView.loadUrl(url)
        }

    }
}