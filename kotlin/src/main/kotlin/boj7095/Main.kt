package boj7095

import kotlin.math.log10

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var i = 1
    var logSum = 0.0
    val answers = mutableListOf<Int>()

    while (true) {
        logSum += log10(i.toDouble())

        if (logSum.toInt() + 1 == n) answers.add(i)
        if (logSum.toInt() + 1 > n) break

        i++
    }

    if (answers.isEmpty()) {
        println("NO")
    } else {
        println(answers.size)
        answers.forEach { println(it) }
    }
}
