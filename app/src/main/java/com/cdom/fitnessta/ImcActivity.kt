package com.cdom.fitnessta

import android.content.Context
import android.content.DialogInterface
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.cdom.fitnessta.databinding.ActivityImcBinding

class ImcActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityImcBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val btnCalcular = binding.btnImcCalc
        btnCalcular.setOnClickListener {
            if(!estaValidado()) {
                Toast.makeText(
                    this,
                    "Preencha os campos corretamente!",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            val peso = binding.editImcPeso.text.toString().toInt()
            val altura = binding.editImcAltura.text.toString().toInt()

            val imc = calcularIMC(peso, altura)

            val dialog = AlertDialog.Builder(this)
            dialog.apply {
                val tituloDialog = getString(R.string.dialog_titulo, imc)
                val msgDialog = getString(mensagemIMC(imc))

                setTitle(tituloDialog)
                setMessage(msgDialog)
                setPositiveButton(R.string.dialog_txt_btn, object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        //aqui vai rodar depois do clique
                    }

                })
                create()
                show()
            }

            val service = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            service.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }

    fun estaValidado(): Boolean {
        val peso = binding.editImcPeso.text.toString()
        val altura = binding.editImcAltura.text.toString()

        if(peso.isBlank()
            || altura.isBlank()
            || peso.startsWith("0")
            || peso.startsWith("0")
        ) return false
        return true
    }

    fun calcularIMC(peso: Int, altura: Int): Double {
        return peso / ((altura/100.0) * (altura/100.0))
    }

    @StringRes
    fun mensagemIMC(imc: Double): Int {
            return if (imc < 15) R.string.peso_sever_baixo
            else if (imc < 16) R.string.peso_muito_baixo
            else if (imc < 18.5) R.string.peso_baixo
            else if (imc < 25.0) R.string.peso_normal
            else if (imc < 30.0) R.string.peso_acima
            else if (imc < 35.0) R.string.peso_muito_acima
            else R.string.peso_sever_alto
    }
}