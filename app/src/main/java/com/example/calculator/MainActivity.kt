package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var tvOne: Button
    lateinit var tvTwo: Button
    lateinit var tvThree: Button
    lateinit var tvFour: Button
    lateinit var tvFive: Button
    lateinit var tvSix: Button
    lateinit var tvSeven: Button
    lateinit var tvEight: Button
    lateinit var tvNine: Button
    lateinit var tvZero: Button

    lateinit var tvPlus: Button
    lateinit var tvMinus: Button
    lateinit var tvDot: Button
    lateinit var tvDivide: Button
    lateinit var tvMul: Button
    lateinit var tvPlusMinus: Button

    lateinit var showNumber: EditText
    lateinit var tvClear: Button
    lateinit var tvEquals: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvZero = findViewById(R.id.tvZero)
        tvOne = findViewById(R.id.tvOne)
        tvTwo = findViewById(R.id.tvTwo)
        tvThree = findViewById(R.id.tvThree)
        tvFour = findViewById(R.id.tvFour)
        tvFive = findViewById(R.id.tvFive)
        tvSix = findViewById(R.id.tvSix)
        tvSeven = findViewById(R.id.tvSeven)
        tvEight = findViewById(R.id.tvEight)
        tvNine = findViewById(R.id.tvNine)

        tvPlus = findViewById(R.id.tvPlus)
        tvMinus = findViewById(R.id.tvMinus)
        tvMul = findViewById(R.id.tvMul)
        tvDivide = findViewById(R.id.tvDivide)
        tvDot = findViewById(R.id.tvDot)
        tvPlusMinus = findViewById(R.id.tvPlusMinus)

        showNumber = findViewById(R.id.etShowNumber)
        tvClear = findViewById(R.id.tvClear)
        tvEquals = findViewById(R.id.tvEquals)

    }

    var isNewOp = true
    var dot = false

    fun NumberEvent(view: View) {
        if (isNewOp) {
            showNumber.setText("")
        }
        isNewOp = false
        val select = view as Button
        var value: String = showNumber.text.toString()
        when (select.id) {
            tvZero.id -> {
                value += "0"
            }
            tvOne.id -> {
                value += "1"
            }
            tvTwo.id -> {
                value += "2"
            }
            tvThree.id -> {
                value += "3"
            }
            tvFour.id -> {
                value += "4"
            }
            tvFive.id -> {
                value += "5"
            }
            tvSix.id -> {
                value += "6"
            }
            tvSeven.id -> {
                value += "7"
            }
            tvEight.id -> {
                value += "8"
            }
            tvNine.id -> {
                value += "9"
            }
            tvDot.id -> {
                if (dot == false) {
                    value += "."
                }
                dot = true
            }
            tvPlusMinus.id -> {
                value = "-$value"
            }
        }
        showNumber.setText(value)
    }

    var op = "X"
    var oldNumber = ""

    fun buOpEvent(view: View) {
        val buSelect = view as Button
        when (buSelect.id) {
            tvMul.id -> {
                op = "X"
            }
            tvDivide.id -> {
                op = "÷"
            }
            tvMinus.id -> {
                op = "-"
            }
            tvPlus.id -> {
                op = "+"
            }
        }
        oldNumber = showNumber.text.toString()
        isNewOp = true
        dot = false
    }

    fun buEqualEvent(view: View) {
        val newNumber = showNumber.text.toString()
        var finalNumber: Double? = null
        when (op) {
            "X" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "÷" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        showNumber.setText(finalNumber.toString())
        isNewOp = true
    }

    fun buPercentEvent(view: View) {
        val number = (showNumber.text.toString().toDouble()) / 100
        showNumber.setText(number.toString())
        isNewOp = true
    }

    fun buCleanEvent(view: View) {
        showNumber.setText("")
        isNewOp = true
        dot = false
    }
}
