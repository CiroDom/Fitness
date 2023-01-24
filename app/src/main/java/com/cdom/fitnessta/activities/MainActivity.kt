package com.cdom.fitnessta.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.cdom.fitnessta.recy_view_main_act.AdapterMainAct
import com.cdom.fitnessta.recy_view_main_act.ItemMain
import com.cdom.fitnessta.R
import com.cdom.fitnessta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val rvMain = binding.rvMain
        val listaItens = mutableListOf<ItemMain>()
        listaItens.add(
            ItemMain(
                id = 1,
                drawableId = R.drawable.ic_baseline_boy_24,
                txtStringId = R.string.texto_qualquer,
                color = Color.GREEN,
            ),
        )
        listaItens.add(
            ItemMain(
                id = 2,
                drawableId = R.drawable.ic_baseline_boy_24,
                txtStringId = R.string.texto_qualquer,
                color = Color.BLACK,
            )
        )
        listaItens.add(
            ItemMain(
                id = 3,
                drawableId = R.drawable.ic_baseline_boy_24,
                txtStringId = R.string.texto_qualquer,
                color = Color.BLUE,
            )
        )
        listaItens.add(
            ItemMain(
                id = 4,
                drawableId = R.drawable.ic_baseline_boy_24,
                txtStringId = R.string.texto_qualquer,
                color = Color.YELLOW,
            )
        )
        val adapter = AdapterMainAct(listaItens) { id ->
            when (id) {
                1 -> {
                    val intent = Intent(this, ImcActivity::class.java)

                    startActivity(intent)
                }
                2 -> {
                    //abrir outra actvty
                }
            }
        }

        rvMain.adapter = adapter
        rvMain.layoutManager = GridLayoutManager(this, 2)

    }
}