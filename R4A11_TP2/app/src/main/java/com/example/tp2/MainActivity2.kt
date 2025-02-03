package com.example.tp2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val displayTextView: TextView = findViewById(R.id.displayTextView)
        val name = intent?.getStringExtra(EXTRA_TEXT)
        val yearOfBirth = intent?.getIntExtra(EXTRA_YEAR, -1) ?: -1

        if (yearOfBirth != -1) {
            val ageCalculator = AgeCalculator()
            val age = ageCalculator.calculateAge(yearOfBirth)
            displayTextView.text = "Hello $name, vous avez $age ans !"
        } else {
            displayTextView.text = "Hello $name, l'âge est mal défini!"
        }

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val EXTRA_TEXT = "com.example.tp2.EXTRA_TEXT"
        const val EXTRA_YEAR = "com.example.tp2.EXTRA_YEAR"
    }
}