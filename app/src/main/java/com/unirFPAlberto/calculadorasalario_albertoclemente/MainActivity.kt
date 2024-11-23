package com.unirFPAlberto.calculadorasalario_albertoclemente

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var textSalary: EditText
    private lateinit var spinnerListPagas: Spinner
    private lateinit var spinnerListDiscapacidad: Spinner
    private lateinit var spinnerListEstadoCivil: Spinner
    private lateinit var btnCalcular: Button
    private lateinit var numEdad: TextView
    private lateinit var btnSumarEdad: FloatingActionButton
    private lateinit var btnRestarEdad: FloatingActionButton
    private lateinit var numHijos: TextView
    private lateinit var btnSumarHijo: FloatingActionButton
    private lateinit var btnRestarHijo: FloatingActionButton

    private var edad: Int = 27
    private var hijos: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


                val salary = findViewById<EditText>(R.id.textSalary)
                val pagas = findViewById<Spinner>(R.id.spinnerListPagas)
                val discapacidad = findViewById<Spinner>(R.id.spinnerListDiscapacidad)
                val numEdad = findViewById<TextView>(R.id.numEdad)
                val btnSumarEdad = findViewById<FloatingActionButton>(R.id.btnSumarEdad)
                val btnRestarEdad = findViewById<FloatingActionButton>(R.id.btnRestarEdad)
                val estadoCivil = findViewById<Spinner>(R.id.spinnerCivil)
                val numHijos = findViewById<TextView>(R.id.numHijos)
                val btnSumarHijo = findViewById<FloatingActionButton>(R.id.btnSumarHijo)
                val btnRestarHijo = findViewById<FloatingActionButton>(R.id.btnRestarHijo)


                btnSumarEdad.setOnClickListener {
                    edad += 1
                    numEdad.text = edad.toString()
                }

                btnRestarEdad.setOnClickListener {
                    edad -= 1
                    numEdad.text = edad.toString()
                }

                btnSumarHijo.setOnClickListener {
                    hijos += 1
                    numHijos.text = hijos.toString()
                }

                btnRestarHijo.setOnClickListener {
                    hijos -= 1
                    numHijos.text = hijos.toString()
                }

        findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnCalcular)
            .setOnClickListener{
                if(salary.text.isNotEmpty()
                    && pagas.selectedItem.toString() != "Pagas"
                    && discapacidad.selectedItem.toString() !="Discapacidad"
                    && estadoCivil.selectedItem.toString() != "Estado civil"){

                       // Log.i("Salario: ", salary.text.toString())
                    //  Log.i("Paga al año: ", pagas.selectedItem.toString())
                    //  Log.i("Discapacidad: ", discapacidad.selectedItem.toString())
                    //   Log.i("Edad: ", edad.toString())
                    //   Log.i("Estado civil: ", estadoCivil.selectedItem.toString())
                    //    Log.i("Número hijos: ", hijos.toString())

                    //llamar a la siguiente vista
                    val intent = Intent(this, ResultadoSalario::class.java)

                    //Metemos los parámetros para pasarlos a la siguiente Activity

                    intent.putExtra("Salario", salary.text.toString())
                    intent.putExtra("Pagas", pagas.selectedItem.toString())
                    intent.putExtra("Discapacidad", discapacidad.selectedItem.toString())
                    intent.putExtra("Edad", edad.toString())
                    intent.putExtra("Estado civil", estadoCivil.selectedItem.toString())
                    intent.putExtra("Hijos:", hijos.toString())

                    //iniciar siguiente activity a través del btnCalcular
                    startActivity(intent)
                }
        }



    }



}