package boj16928

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val ladders = mutableMapOf<Int, Int>()
    val snakes = mutableMapOf<Int, Int>()

    repeat(n) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        ladders[start] = end
    }

    repeat(m) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        snakes[start] = end
    }

    val visited = BooleanArray(101) { false }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(1 to 0)
    visited[1] = true

    while (queue.isNotEmpty()) {
        val (current, count) = queue.poll()

        if (current == 100) {
            println(count)
            return@with
        }

        for (i in 1..6) {
            var next = current + i
            if (next > 100) continue

            ladders[next]?.let { next = it }
            snakes[next]?.let { next = it }

            if (!visited[next]) {
                visited[next] = true
                queue.add(next to count + 1)
            }
        }
    }
}