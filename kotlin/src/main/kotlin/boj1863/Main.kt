package boj1863

import java.util.Stack

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val points = Array(n) { readLine().split(" ").map { it.toInt() } }

    val stack = Stack<Int>()
    var result = 0

    for (i in points.indices) {
        val y = points[i][1]

        while (stack.isNotEmpty() && stack.peek() > y) {
            stack.pop()
            result++
        }

        if (stack.isEmpty() || stack.peek() < y) {
            stack.push(y)
        }
    }

    while (stack.isNotEmpty()) {
        if (stack.pop() > 0) {
            result++
        }
    }

    println(result)
}
