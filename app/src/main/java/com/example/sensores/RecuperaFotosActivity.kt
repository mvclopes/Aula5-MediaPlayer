package com.example.sensores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.sensores.databinding.ActivityRecuperaFotosBinding

class RecuperaFotosActivity : AppCompatActivity() {

    private val binding: ActivityRecuperaFotosBinding by lazy { ActivityRecuperaFotosBinding.inflate(layoutInflater) }
    private val animais = arrayOf("Leão", "Pinguim", "Urso", "Girafa", "Tigre", "Rato")
    private val imagens = arrayOf(
        "https://www.infoescola.com/wp-content/uploads/2017/04/leao-126767138.jpg",
        "https://www.infoescola.com/wp-content/uploads/2010/11/pinguim-real_103683425.jpg",
        "https://www.cnnbrasil.com.br/wp-content/uploads/sites/12/2022/08/2022-08-11T135857Z_1_LWD798211082022RP1_RTRWNEV_E_7982-TURKEY-BEAR.jpg?w=768",
        "https://www.infoescola.com/wp-content/uploads/2008/04/girafa-336x450.jpg",
        "https://s3.static.brasilescola.uol.com.br/be/2022/01/tigre.jpg",
        "https://www.landrin.com.br/upload/pragas_5_66_1538744895.jpg"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            txtView1.text = animais[0]
            txtView2.text = animais[1]
            txtView3.text = animais[2]
            txtView4.text = animais[3]
            txtView5.text = animais[4]
            txtView6.text = animais[5]

            Glide.with(this@RecuperaFotosActivity).load(imagens[0]).into(imgView1)
            Glide.with(this@RecuperaFotosActivity).load(imagens[1]).into(imgView2)
            Glide.with(this@RecuperaFotosActivity).load(imagens[2]).into(imgView3)
            Glide.with(this@RecuperaFotosActivity).load(imagens[3]).into(imgView4)
            Glide.with(this@RecuperaFotosActivity).load(imagens[4]).into(imgView5)
            Glide.with(this@RecuperaFotosActivity).load(imagens[5]).into(imgView6)
        }
    }
}