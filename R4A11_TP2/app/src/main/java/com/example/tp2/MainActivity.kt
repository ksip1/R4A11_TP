package com.example.tp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstButton: Button = findViewById(R.id.firstButton)
        val nameEditText: EditText = findViewById(R.id.editText)
        val yearEditText: EditText = findViewById(R.id.yearEditText)

        firstButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val yearOfBirth = yearEditText.text.toString().toIntOrNull() ?: -1

            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra(MainActivity2.EXTRA_TEXT, name)
                putExtra(MainActivity2.EXTRA_YEAR, yearOfBirth)
            }
            startActivity(intent)
        }
    }
}