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
    private val url = "https://www.fiap.com.br/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    if (!url.isNullOrBlank()) {
                        view?.loadUrl(url)
                    }
                    return true
                }
            }
            webView.settings.javaScriptEnabled = true
            webView.loadUrl(url)
        }

    }
}