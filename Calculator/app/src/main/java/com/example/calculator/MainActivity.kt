package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clearBTN.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        openBracketBTN.setOnClickListener {
            input.text = addToInputText("(")
        }
        closedBracketBTN.setOnClickListener {
            input.text = addToInputText(")")
        }
        zeroBTN.setOnClickListener {
            input.text = addToInputText("0")
        }
        oneBTN.setOnClickListener {
            input.text = addToInputText("1")
        }
        twoBTN.setOnClickListener {
            input.text = addToInputText("2")
        }
        threeBTN.setOnClickListener {
            input.text = addToInputText("3")
        }
        fourBTN.setOnClickListener {
            input.text = addToInputText("4")
        }
        fiveBTN.setOnClickListener {
            input.text = addToInputText("5")
        }
        sixBTN.setOnClickListener {
            input.text = addToInputText("6")
        }
        sevenBTN.setOnClickListener {
            input.text = addToInputText("7")
        }
        eightBTN.setOnClickListener {
            input.text = addToInputText("8")
        }
        nineBTN.setOnClickListener {
            input.text = addToInputText("9")
        }
        decimalBTN.setOnClickListener {
            input.text = addToInputText(".")
        }
        divisionBTN.setOnClickListener {
            input.text = addToInputText("÷") // ALT + 0247
        }
        multiplicationBTN.setOnClickListener {
            input.text = addToInputText("×") // ALT + 0215
        }
        substractionBTN.setOnClickListener {
            input.text = addToInputText("-")
        }
        additionBTN.setOnClickListener {
            input.text = addToInputText("+")
        }
        powerBTN.setOnClickListener {
            input.text = addToInputText("^")
        }
        equalstoBTN.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {
        return "${input.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}