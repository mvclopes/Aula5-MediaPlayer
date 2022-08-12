package com.example.sensores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.sensores.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

    // Map de String e Int das animações
    private val animationsMap = mapOf(
        "Fade In" to R.anim.fade_in,
        "Fade Out" to R.anim.fade_out,
        "Zoom In" to R.anim.zoom_in,
        "Zoom Out" to R.anim.zoom_out,
        "Blink" to R.anim.blink,
        "Rotate" to R.anim.rotate,
        "Move" to R.anim.move,
        "Slide Up" to R.anim.slide_up,
        "Slide Down" to R.anim.slide_down,
        "Bounce" to R.anim.bounce
    )

    // Lista contendo nome das animações
    private val animationsName = animationsMap.keys.toList()

    // Lista contendo id das animações
    private val animationsId = animationsMap.values.toList()

    private val binding: ActivityAnimationsBinding by lazy { ActivityAnimationsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configureAdapter()
        onItemAnimation()
    }

    // Método responsável por configurar listener para clique nos itens da ListView
    private fun onItemAnimation() {
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                // Carregamento da animação clicada de acordo com sua posição
                val animation = AnimationUtils.loadAnimation(
                    this,
                    animationsId[position]
                )
                // Iniciada a animação na view especificada
                binding.txtView.startAnimation(animation)
            }
    }

    // Método responsável por configurar o adapter do componente ListView, fornecendo a lista de nomes das animações
    private fun configureAdapter() {
        binding.listView.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, animationsName)
    }
}