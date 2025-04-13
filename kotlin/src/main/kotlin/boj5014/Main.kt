package boj5014

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    val (f, s, g, u, d) = readLine().split(" ").map { it.toInt() }

    val visited = BooleanArray(f + 1) { false }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(s, 0))
    visited[s] = true

    var result = -1

    while (queue.isNotEmpty()) {
        val (current, count) = queue.poll()

        if (current == g) {
            result = count
            break
        }

        val nextUp = current + u
        val nextDown = current - d

        if (nextUp <= f && !visited[nextUp]) {
            visited[nextUp] = true
            queue.add(Pair(nextUp, count + 1))
        }

        if (nextDown >= 1 && !visited[nextDown]) {
            visited[nextDown] = true
            queue.add(Pair(nextDown, count + 1))
        }
    }

    if (result == -1) println("use the stairs") else println(result)
}
