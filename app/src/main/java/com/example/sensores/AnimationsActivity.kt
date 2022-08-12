package com.example.sensores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.sensores.databinding.ActivityAnimationsBinding

class AnimationsActivity : AppCompatActivity() {

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
    private val animationsName = animationsMap.keys.toList()
    private val animationsId = animationsMap.values.toList()

    private val binding: ActivityAnimationsBinding by lazy { ActivityAnimationsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, animationsName)
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val animation = AnimationUtils.loadAnimation(
                this,
                animationsId[position]
            )
            binding.txtView.startAnimation(animation)
        }
    }
}