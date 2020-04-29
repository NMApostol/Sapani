package com.example.sapani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val patienten = resources.getStringArray(R.array.Patienten)
        val spinner = findViewById<Spinner>(R.id.dd_patienten)
        val button = findViewById<Button>(R.id.simpleButton1)
        val wundGroese = findViewById<EditText>(R.id.editText1)
        val wunden = mutableListOf<Number>()
        val prozentAusgabe = findViewById<TextView>(R.id.TextView3)

        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, patienten)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    if (patienten[position] != "Auswählen...")
                    Toast.makeText(this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + patienten[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        var ersteWunde: Double = 0.0
        var zweiteWunde: Double = 0.0
        var wundenAnzahl = 0
        button.setOnClickListener {
            if (spinner.selectedItem != patienten[0]) {
                var wund = wundGroese.getText().toString()
                if (wund != "") {
                    var eingabe = wundGroese.getText().toString().toDouble()
                    if (wundenAnzahl == 0) {
                        ersteWunde = eingabe
                        wundenAnzahl++
                    }
                    else if (wundenAnzahl == 1) {
                        zweiteWunde = eingabe
                        wundenAnzahl++
                    }
                    else if (wundenAnzahl == 2) {
                        var wunde = zweiteWunde
                        ersteWunde = wunde
                        zweiteWunde = eingabe
                    }
                    if (wundenAnzahl == 2) {
                        var rechner = Rechner(ersteWunde, zweiteWunde)
                        var prozent = rechner.prozent()
                        prozentAusgabe.setText(prozent.toString() + "%")
                    }
                    wundGroese.setText(null)
                    Toast.makeText(this@MainActivity, "Wundgröße wurde gespeichert.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Keine Wundgröße eingegeben.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "Keinen Patienten ausgewählt!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
