package boj6593

import java.util.LinkedList
import java.util.Queue

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val (l, r, c) = readLine().split(" ").map { it.toInt() }
        if (l == 0 && r == 0 && c == 0) break

        val building = Array(l) { Array(r) { CharArray(c) } }
        val visited = Array(l) { Array(r) { IntArray(c) { -1 } } }

        var start: Triple<Int, Int, Int>? = null

        repeat(l) { floor ->
            repeat(r) { row ->
                val line = readLine()
                repeat(c) { col ->
                    val target = line[col]
                    if (target == 'S') start = Triple(floor, row, col)
                    building[floor][row][col] = target
                }
            }
            readLine() // 빈 줄 처리
        }

        val directions = listOf(
            Triple(1, 0, 0),
            Triple(-1, 0, 0),
            Triple(0, 1, 0),
            Triple(0, -1, 0),
            Triple(0, 0, 1),
            Triple(0, 0, -1)
        )

        val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
        var escaped = false

        start?.let {
            queue.add(it)
            visited[it.first][it.second][it.third] = 0
        }

        while (queue.isNotEmpty()) {
            val (floor, row, col) = queue.poll()
            val time = visited[floor][row][col]

            if (building[floor][row][col] == 'E') {
                println("Escaped in $time minute(s).")
                escaped = true
                break
            }

            for ((df, dr, dc) in directions) {
                val nf = floor + df
                val nr = row + dr
                val nc = col + dc

                if (
                    nf in 0 until l && nr in 0 until r && nc in 0 until c &&
                    visited[nf][nr][nc] == -1 && building[nf][nr][nc] != '#'
                ) {
                    visited[nf][nr][nc] = time + 1
                    queue.add(Triple(nf, nr, nc))
                }
            }
        }

        if (!escaped) println("Trapped!")
    }
}
