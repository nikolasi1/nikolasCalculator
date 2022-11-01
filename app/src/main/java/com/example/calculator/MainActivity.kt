package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var text1: TextView

    private var operation = " "
    private var operand1 = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        text1 = findViewById(R.id.textView)

    }

    fun onclick(clickedview: View) {
        if (clickedview is TextView) {
            val number = clickedview.text.toString()
            var text = text1.text.toString()

            if (text == "0") {
                text = ""
            }
            text1.text = text + number

        }

    }

    fun operationClick(clickedview: View) {
        if (clickedview is TextView) {
            operation = clickedview.text.toString()

            operand1 = text1.text.toString().toDouble()
            text1.text = "0"
        }

    }

    fun equalsClick(clickedview: View) {

        val operand2 = text1.text.toString().toDouble()
        if (operation == " ") {
            text1.text = text1.text.toString()
        } else {
            when (operation) {

                "+" -> text1.text = (operand1 + operand2).toString()
                "-" -> text1.text = (operand1 - operand2).toString()
                "*" -> text1.text = (operand1 * operand2).toString()
                "/" -> text1.text = (operand1 / operand2).toString()

            }
            operation = " "

            var newnumber = text1.text.toString()
            if (newnumber.substring(newnumber.length - 2, newnumber.length) == ".0") {
                text1.text = newnumber.substring(0, newnumber.length - 2)
            }
        }

    }

    fun cleartxt(view: View) {
        text1.text = "0"
        operand1 = 0.0
    }

    fun delete(view: View) {
        val newoperand1 = operand1.toString().substring(0, operand1.toString().length - 2)

        val txt = text1.text.toString()

        if (txt.length == 1 && operand1 == 0.0) {
            text1.text = "0"
        } else if (txt.length == 1) {
            text1.text = newoperand1
            operand1 = 0.0

        } else {
            text1.text = txt.substring(0, txt.length - 1)
        }
    }

    fun dotclick(view: View) {
        var dotexists = false
        val txt = text1.text.toString()
        for (element in txt) {
            if (element == '.') {
                dotexists = true
            }
        }
        if (!dotexists) {
            text1.text = txt + '.'
        }

    }


}



