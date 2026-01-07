package boj201

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val expects = IntArray(n) {
        readLine().toInt()
    }

    expects.sort()

    var sum = 0L
    for (i in 0 until n) {
        sum += abs((i + 1) - expects[i])
    }

    println(sum)
}