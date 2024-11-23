package com.unirFPAlberto.calculadorasalario_albertoclemente
import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoSalario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_salario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //recoger los textViews
        val resSalario = findViewById<TextView>(R.id.resultSalario)
        val resPagas = findViewById<TextView>(R.id.resultPagas)
        val resDiscapacidad = findViewById<TextView>(R.id.resultDiscapacidad)
        val resEdad = findViewById<TextView>(R.id.resultEdad)
        val resEstado = findViewById<TextView>(R.id.resultEstado)
        val resHijos = findViewById<TextView>(R.id.resultHijos)

        //Recogemos los putExtras del ActivityMain

        val salary: String = intent.extras?.getString("Salario").orEmpty().toString()
        val pagas: String = intent.extras?.getString("Pagas").orEmpty().toString()
        val discapacidad: String = intent.extras?.getString("Discapacidad").orEmpty().toString()
        val edad: String = intent.extras?.getString("Edad").orEmpty().toString()
        val estCivil: String = intent.extras?.getString("Estado civil").orEmpty().toString()
        val hijos: String = intent.extras?.getString("Hijos:").orEmpty().toString()

        resSalario.text = salary
        resPagas.text = pagas
        resDiscapacidad.text = discapacidad
        resEdad.text = edad
        resEstado.text = estCivil
        resHijos.text = hijos
    }



}