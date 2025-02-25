package boj2583

import java.util.LinkedList
import java.util.Queue

val dx = arrayOf(1, -1, 0, 0)
val dy = arrayOf(0, 0, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n, k) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { BooleanArray(m) }

    repeat(k) {
        val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
        for (i in x1..<x2) {
            for (j in y1..<y2) {
                map[i][j] = true
            }
        }
    }

    val visited = Array(n) { BooleanArray(m) }
    val areaSizes = mutableListOf<Int>()

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (!visited[i][j] && !map[i][j]) {
                areaSizes.add(bfs(i, j, visited, map))
            }
        }
    }

    areaSizes.sort()
    println(areaSizes.size)
    println(areaSizes.joinToString(" "))
}

fun bfs(startX: Int, startY: Int, visited: Array<BooleanArray>, map: Array<BooleanArray>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(startX to startY)
    visited[startX][startY] = true

    var areaSize = 0

    while (queue.isNotEmpty()) {
        val (currentX, currentY) = queue.poll()
        areaSize++

        for (i in 0..<4) {
            val nextX = currentX + dx[i]
            val nextY = currentY + dy[i]

            if (nextX in map.indices && nextY in 0..<map[0].size) {
                if (!visited[nextX][nextY] && !map[nextX][nextY]) {
                    visited[nextX][nextY] = true
                    queue.add(nextX to nextY)
                }
            }
        }
    }

    return areaSize
}
