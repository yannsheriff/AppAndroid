package com.example.ycherif.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import android.content.Intent



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloText : TextView = findViewById(R.id.hello)

        helloText.text = "yo"

        val okButton : Button = findViewById(R.id.button)
        val goButton : Button = findViewById(R.id.button2)

//        okButton.setOnClickListener {
//            Toast.makeText(this, "Goddaaaaam", Toast.LENGTH_SHORT)
//                    .show()
//        }


        val seekBar : SeekBar = findViewById(R.id.seekBar)
        val seekBarText : TextView = findViewById(R.id.seekBarText)





        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                seekBarText.text = "$progress"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

        })


        okButton.setOnClickListener {
            val intent : Intent = Intent(this, Main2Activity::class.java)
                    .putExtra("rating", seekBar.progress)
            startActivity(intent)
        }

        goButton.setOnClickListener {
            val intent : Intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        }









        // findViewById(R.id.hello)
    }
}