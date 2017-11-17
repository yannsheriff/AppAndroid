package com.example.ycherif.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.content.Intent



class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Get the Intent that started this activity and extract the string
        val intent = intent
        val message = intent.getIntExtra("rating", 0)


        // Capture the layout's TextView and set the string as its text
        val textView : TextView = findViewById(R.id.textView)
        textView.text = "$message"

    }


}
