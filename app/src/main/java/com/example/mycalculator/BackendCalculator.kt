package com.example.mycalculator


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel


class BackendCalculator : ViewModel() {

    // Display text (state observed by UI)
    private val _displayText = mutableStateOf("0")
    val displayText: State<String> = _displayText


    private var currentExpression = ""

    // Add number or operator
    fun onInput(value: String) {
        if (_displayText.value == "0" && value != ".") {
            currentExpression = ""
        }
        currentExpression += value
        _displayText.value = currentExpression
    }

    // Clear everything
    fun clear() {
        currentExpression = ""
        _displayText.value = "0"
    }

    // Delete last character
    fun backspace() {
        if (currentExpression.isNotEmpty()) {
            currentExpression = currentExpression.dropLast(1)
            _displayText.value = if (currentExpression.isEmpty()) "0" else currentExpression
        }
    }

    // Perform calculation
    fun calculateResult() {
        try {
            val result = evaluateExpression(currentExpression)
            _displayText.value = result.toString()
            currentExpression = result.toString()
        } catch (e: Exception) {
            _displayText.value = "Error"
        }
    }

    // Private calculator function (Kotlin only)
//    private fun evaluateExpression(expr: String): Double {
//        val safeExpr = expr
//            .replace("×", "*")
//            .replace("÷", "/")
//
//        val engine = ScriptEngineManager().getEngineByName("rhino")
//        val result = engine.eval(safeExpr)
//
//        return (result as? Double) ?: result.toString().toDouble()
//    }

    private fun evaluateExpression(expr: String): Double {
        val safeExpr = expr
            .replace("×", "*")
            .replace("÷", "/")

        return try {
            // Simple math evaluator using built-in Kotlin
            val result = calculateSimpleExpression(safeExpr)
            result
        } catch (e: Exception) {
            Double.NaN
        }
    }

    // Custom simple calculator function
    private fun calculateSimpleExpression(expression: String): Double {
        val cleanExpr = expression.replace(Regex("[^0-9+\\-*/.]"), "")

        // Only supports + - * / (basic calculator)
        val tokens = cleanExpr.split("(?<=[-+*/])|(?=[-+*/])".toRegex())

        var result = tokens[0].toDouble()
        var currentOp = ""

        for (token in tokens.drop(1)) {
            when (token) {
                "+", "-", "*", "/" -> currentOp = token
                else -> {
                    val number = token.toDoubleOrNull() ?: continue
                    result = when (currentOp) {
                        "+" -> result + number
                        "-" -> result - number
                        "*" -> result * number
                        "/" -> result / number
                        else -> result
                    }
                }
            }
        }
        return result
    }

}
