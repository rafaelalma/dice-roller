package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

// This activity allows the user to roll one dice and view the result on the screen.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice(6) }

        // Do a dice roll when the app starts.
        rollDice(6)
    }

    // Roll one dice.
    private fun rollDice(numSides: Int) {

        // Create a Dice object with 6 sides and roll it.
        val dice = Dice(numSides)
        val diceRoll = dice.roll()

        updateImageView(diceRoll)
    }

    // Update the screen with the result.
    private fun updateImageView(diceRoll: Int) {

        // Find the ImageView in the layout.
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll.
        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the Image View and its content description.
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