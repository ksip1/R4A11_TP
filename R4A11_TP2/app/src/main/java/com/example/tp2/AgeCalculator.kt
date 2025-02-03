package com.example.tp2

import java.util.Calendar

class AgeCalculator {
    fun calculateAge(yearOfBirth: Int): Int {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        return currentYear - yearOfBirth
    }
}