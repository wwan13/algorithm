package boj2467

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toLong() }.sorted()

    var left = 0
    var right = n - 1
    var min = Long.MAX_VALUE
    var result = 0L to 0L

    while (left < right) {
        val sum = list[left] + list[right]

        if (abs(sum) < min) {
            min = abs(sum)
            result = list[left] to list[right]
        }

        if (sum < 0) left += 1 else right -= 1
    }

    println("${result.first} ${result.second}")
}