package boj4179

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    val map = Array(r) { readLine().toCharArray() }

    val fireDist = Array(r) { IntArray(c) { -1 } }
    val jihunDist = Array(r) { IntArray(c) { -1 } }

    val queue: Queue<Pair<Int, Int>> = LinkedList()

    var jihunStart: Pair<Int, Int>? = null

    for (i in 0 until r) {
        for (j in 0 until c) {
            when (map[i][j]) {
                'F' -> {
                    queue.add(i to j)
                    fireDist[i][j] = 0
                }

                'J' -> {
                    jihunStart = i to j
                    jihunDist[i][j] = 0
                }
            }
        }
    }

    val dx = listOf(-1, 1, 0, 0)
    val dy = listOf(0, 0, -1, 1)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (d in 0..3) {
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx in 0 until r && ny in 0 until c) {
                if (map[nx][ny] != '#' && fireDist[nx][ny] == -1) {
                    fireDist[nx][ny] = fireDist[x][y] + 1
                    queue.add(nx to ny)
                }
            }
        }
    }

    queue.clear()
    queue.add(jihunStart!!)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        if (x == 0 || x == r - 1 || y == 0 || y == c - 1) {
            println(jihunDist[x][y] + 1)
            return
        }

        for (d in 0..3) {
            val nx = x + dx[d]
            val ny = y + dy[d]

            if (nx in 0 until r && ny in 0 until c) {
                if (map[nx][ny] != '#' && jihunDist[nx][ny] == -1) {
                    if (fireDist[nx][ny] == -1 || jihunDist[x][y] + 1 < fireDist[nx][ny]) {
                        jihunDist[nx][ny] = jihunDist[x][y] + 1
                        queue.add(nx to ny)
                    }
                }
            }
        }
    }

    println("IMPOSSIBLE")
}
