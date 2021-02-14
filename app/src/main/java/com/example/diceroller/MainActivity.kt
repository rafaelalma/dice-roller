package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

// This activity allows the user to roll two dices and view the result on the screen.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceLeftImageView: ImageView = findViewById(R.id.diceLeftImageView)
        val diceRightImageView: ImageView = findViewById(R.id.diceRightImageView)

        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener {
            updateImageView(rollDice(6), diceLeftImageView)
            updateImageView(rollDice(6), diceRightImageView)
        }

        // Roll two dices when the app starts.
        updateImageView(rollDice(6), diceLeftImageView)
        updateImageView(rollDice(6), diceRightImageView)
    }

    private fun rollDice(numSides: Int): Int {

        val dice = Dice(numSides)
        return dice.roll()
    }

    private fun updateImageView(diceRoll: Int, diceImage: ImageView) {

        // Determine which drawable resource ID to use based on the dice roll.
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

// This class defines a dice with a number of sides and a roll behaviour.
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}