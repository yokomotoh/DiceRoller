package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numSidesDice1: Int = 6
        /*
        val resultTextView1: TextView = findViewById(R.id.textView3)
        resultTextView1.text = numSidesDice1.toString()
        */
        val numSidesDice2: Int = 6
        /*
        val resultTextView2: TextView = findViewById(R.id.textView4)
        resultTextView2.text = numSidesDice2.toString()
        */

        var rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice(numSidesDice1, R.id.imageView) }
            /*
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            // Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            */
            /*
            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "6"
            */
            rollDice(numSidesDice1, R.id.imageView)
            Toast.makeText(this, "Dice1 Rolled!", Toast.LENGTH_SHORT).show()
        //}

        var rollButton2: Button = findViewById(R.id.button2)
        rollButton2.setOnClickListener {
            rollDice(numSidesDice2, R.id.imageView2) }
            rollDice(numSidesDice2, R.id.imageView2)
            Toast.makeText(this, "Dice2 Rolled!", Toast.LENGTH_SHORT).show()
        //}

        var rollButton3: Button = findViewById(R.id.button3)
        rollButton3.setOnClickListener {
            rollDice(numSidesDice1, R.id.imageView)
            rollDice(numSidesDice2, R.id.imageView2)
        }
    }

    private fun rollDice(numSidesRoll: Int, imageViewId: Int) {
        val dice = Dice(numSidesRoll)
        val diceRoll = dice.roll()
        /*
        val resultTextView: TextView = findViewById(textViewId)
        resultTextView.text = diceRoll.toString()
        */
        val diceImage: ImageView = findViewById(imageViewId)
        // diceImage.setImageResource(R.drawable.dice_2)

        val drawableResource = when (diceRoll) {
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

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}