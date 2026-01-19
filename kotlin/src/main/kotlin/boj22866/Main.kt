package boj22866

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val buildings = readLine().split(" ").map { it.toInt() }.toIntArray()

    val count = IntArray(n)
    val nearest = IntArray(n) { -1 }

    // 왼쪽
    val leftStack = ArrayDeque<Int>()
    for (i in 0 until n) {
        while (leftStack.isNotEmpty() && buildings[leftStack.last()] <= buildings[i]) {
            leftStack.removeLast()
        }

        count[i] += leftStack.size
        if (leftStack.isNotEmpty()) {
            nearest[i] = leftStack.last()
        }

        leftStack.addLast(i)
    }

    // 오른쪽
    val rightStack = ArrayDeque<Int>()
    for (i in n - 1 downTo 0) {
        while (rightStack.isNotEmpty() && buildings[rightStack.last()] <= buildings[i]) {
            rightStack.removeLast()
        }

        count[i] += rightStack.size

        if (rightStack.isNotEmpty()) {
            val candidate = rightStack.last()

            val current = nearest[i]
            if (
                current == -1 ||
                abs(candidate - i) < abs(current - i) ||
                (abs(candidate - i) == abs(current - i) && candidate < current)
            ) {
                nearest[i] = candidate
            }
        }

        rightStack.addLast(i)
    }

    for (i in 0 until n) {
        if (count[i] == 0) {
            println(0)
        } else {
            println("${count[i]} ${nearest[i] + 1}")
        }
    }
}