package com.example.tp2

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TEXT = "text_to_display"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstButton: Button = findViewById(R.id.firstButton)
        val textView: TextView = findViewById(R.id.textView)
        val editText: TextInputEditText = findViewById(R.id.editText)
        val nextButton: Button = findViewById(R.id.next)
        val textView2: TextView = findViewById(R.id.textView2)

        textView2.text = Html.fromHtml("<b>Bienvenue</b>")

        firstButton.setOnClickListener {
            textView.text = editText.text.toString()
        }

        nextButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra(EXTRA_TEXT, editText.text.toString())
            startActivity(intent)
        }
    }
}