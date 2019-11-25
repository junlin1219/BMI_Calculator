package com.example.bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageBMI.setImageResource(R.drawable.empty)
        textResultBMI.text = null

        //call button onClick function
        buttonCalculate.setOnClickListener() {
            calBMI();
        }

        buttonReset.setOnClickListener() {
            //todo:: clear input & result
            inputWeight.setText("")
            inputHeight.setText("")
            textResultBMI.setText("")
            //todo:: clear image
            imageBMI.setImageResource(R.drawable.empty)
            inputWeight.requestFocus()
        }
    }

    private fun calBMI() {

        try {
            val weight: Double = inputWeight.text.toString().toDouble()
            val height: Double = inputHeight.text.toString().toDouble()

            val resultBMI: Double = weight / (height * height)
            val bmiImage: ImageView = findViewById(R.id.imageBMI)

            //display result
            if (resultBMI < 18.5) {
                imageBMI.setImageResource(R.drawable.under)
                textResultBMI.text = "BMI: %.2f (Underweight)".format(resultBMI)
            } else if (resultBMI >= 18.5 && resultBMI <= 24.9) {
                imageBMI.setImageResource(R.drawable.normal)
                textResultBMI.text = "BMI: %.2f (Normal)".format(resultBMI)
            } else {
                imageBMI.setImageResource((R.drawable.over))
                textResultBMI.text = "BMI: %.2f (Overweight)".format(resultBMI)
            }

        } catch (e: Exception) {
            val toast: Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)

            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }

    /*
     *
     *
     */
}
