package com.example.seventhSem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Preview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        val bundle:Bundle? = intent.extras
        if (bundle!=null) {
            val titleTextView = findViewById<TextView>(R.id.titleText)
            val title = bundle.getString("title")
            titleTextView.text = title
        }

    }
}