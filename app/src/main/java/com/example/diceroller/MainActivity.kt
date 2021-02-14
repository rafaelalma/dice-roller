package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

// This activity allows the user to roll two dices and view the results on the screen.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice(6, R.id.textView) }
    }

    private fun rollDice(numSides: Int, id: Int) {
        val dice = Dice(numSides)
        val diceRoll = dice.roll()

        updateTextView(id, diceRoll)
    }

    private fun updateTextView(id: Int, diceRoll: Int) {
        val resultTextView: TextView = findViewById(id)
        resultTextView.text = diceRoll.toString()
    }
}

// This class defines a dice with a number of sides and a roll behaviour.
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}