package boj9205

import java.util.ArrayDeque
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().trim().toInt()

    repeat(t) {
        val n = readLine().trim().toInt()

        val points = ArrayList<Pair<Int, Int>>(n + 2)

        repeat(n + 2) {
            val (x, y) = readLine().split(" ").map { it.toInt() }
            points.add(x to y)
        }

        fun canGo(a: Pair<Int, Int>, b: Pair<Int, Int>): Boolean {
            return abs(a.first - b.first) + abs(a.second - b.second) <= 1000
        }

        val visited = BooleanArray(n + 2)
        val queue: ArrayDeque<Int> = ArrayDeque()
        queue.addLast(0)
        visited[0] = true

        var ok = false
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            if (cur == n + 1) {
                ok = true
                break
            }

            for (next in 1 until n + 2) {
                if (visited[next]) continue
                if (canGo(points[cur], points[next])) {
                    visited[next] = true
                    queue.addLast(next)
                }
            }
        }

        println(if (ok) "happy" else "sad")
    }
}