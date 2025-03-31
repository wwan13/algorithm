package boj16234

import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val (n, l, r) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    val range = l..r

    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)

    fun dfs(x: Int, y: Int, visited: Array<BooleanArray>, opened: MutableList<Pair<Int, Int>>): Int {
        visited[x][y] = true
        opened += x to y
        var sum = map[x][y]

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until n && ny in 0 until n && !visited[nx][ny]) {
                val diff = abs(map[nx][ny] - map[x][y])
                if (diff in range) {
                    sum += dfs(nx, ny, visited, opened)
                }
            }
        }
        return sum
    }

    var days = 0
    while (true) {
        val visited = Array(n) { BooleanArray(n) }
        var moved = false

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visited[i][j]) {
                    val opened = mutableListOf<Pair<Int, Int>>()
                    val totalSum = dfs(i, j, visited, opened)

                    if (opened.size > 1) {
                        val avg = totalSum / opened.size
                        for ((x, y) in opened) {
                            map[x][y] = avg
                        }
                        moved = true
                    }
                }
            }
        }

        if (!moved) break
        days++
    }

    println(days)
}
