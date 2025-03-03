package boj14888

import kotlin.math.max
import kotlin.math.min

var maxValue = Int.MIN_VALUE
var minValue = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val numbers = readLine().split(" ").map { it.toInt() }
    val operators = readLine().split(" ").map { it.toInt() }

    backtrack(n, numbers, operators, 1, numbers[0])

    println(maxValue)
    println(minValue)
}

private fun backtrack(n: Int, numbers: List<Int>, operators: List<Int>, depth: Int, result: Int) {
    if (depth == n) {
        maxValue = max(maxValue, result)
        minValue = min(minValue, result)
        return
    }

    for (i in 0..<4) {
        if (operators[i] > 0) {
            val newOperators = operators.toMutableList().apply { this[i]-- }
            val newResult = when (i) {
                0 -> result + numbers[depth]
                1 -> result - numbers[depth]
                2 -> result * numbers[depth]
                3 -> result / numbers[depth]
                else -> result
            }
            backtrack(n, numbers, newOperators, depth + 1, newResult)
        }
    }
}
