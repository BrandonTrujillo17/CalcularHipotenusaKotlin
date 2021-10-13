package com.example.calcularhipotenusa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Math.sqrt
import java.math.BigDecimal
import java.math.RoundingMode


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btn_calcular = findViewById<Button>(R.id.btn_calcular)
        var btn_limpiar = findViewById<Button>(R.id.btn_limpiar)
        var txt_catetoA = findViewById<EditText>(R.id.txt_catetoA)
        var txt_catetoB = findViewById<EditText>(R.id.txt_catetoB)
        var tv_resultado = findViewById<TextView>(R.id.txtView_resultado)
        var tv_mensajes = findViewById<TextView>(R.id.tv_mensajes)

        btn_calcular.setOnClickListener(){
            var catetoA = txt_catetoA.text.toString()
            var catetoB = txt_catetoB.text.toString()
            var resultado : Double

            if((catetoA.length != 0) || (catetoB.length != 0)){
                tv_mensajes.setText("")
                resultado = calcularHipotenusa(catetoA, catetoB)
                var resultadoDecimal: BigDecimal = BigDecimal(resultado)
                resultadoDecimal = resultadoDecimal.setScale(2, RoundingMode.HALF_UP)
                tv_resultado.setText(resultadoDecimal.toString())
            }else{
                Toast.makeText(this, "Favor de llenar todos los campos", Toast.LENGTH_LONG).show()
            }
        }

        btn_limpiar.setOnClickListener(){
            txt_catetoA.setText("")
            txt_catetoB.setText("")
            tv_resultado.setText("")
            tv_mensajes.setText("")
        }
    }

    fun calcularHipotenusa(catetoA: String, catetoB: String) : Double{
        var ladoA = catetoA.toDouble()
        var ladoB = catetoB.toDouble()
        var resultado = (potenciarNumero(ladoA) + potenciarNumero(ladoB))
        return sqrt(resultado)
    }

    fun potenciarNumero(lado: Double) : Double{
        var potencia = lado * lado
        return potencia
    }
}