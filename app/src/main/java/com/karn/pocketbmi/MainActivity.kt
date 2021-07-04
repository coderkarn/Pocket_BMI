package com.karn.pocketbmi

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var calculateButton: TextView
    lateinit var weightEditText: EditText
    lateinit var heightEditText: EditText
    lateinit var bmiTextView: TextView
    lateinit var bmiImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButton = findViewById(R.id.calculate_button)
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        bmiTextView = findViewById(R.id.bmi_text_view)
        bmiImageView = findViewById(R.id.bmi_image_view)

        calculateButton.setOnClickListener {

            if (weightEditText.text.isNotEmpty() && heightEditText.text.isNotEmpty()) {
                calculateBMI()
            }else {
                Toast.makeText(this, "Enter correct field", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun calculateBMI(){
        val weight = weightEditText.text.toString().toFloat()
        val height = heightEditText.text.toString().toFloat()

        val myBMI = weight / (height * height)

        bmiTextView.text = myBMI.toString()

        if (myBMI < 18.5) {
            bmiImageView.setImageResource(R.drawable.underweight)
        } else if (myBMI >= 18.5 && myBMI < 24.9) {
            bmiImageView.setImageResource(R.drawable.healthy)
        } else if (myBMI >= 24.9 && myBMI < 29.9) {
            bmiImageView.setImageResource(R.drawable.overweight)
        } else if (myBMI >= 29.9) {
            bmiImageView.setImageResource(R.drawable.obesity)
        }

    }
}