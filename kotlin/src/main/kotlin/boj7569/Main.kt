package boj7569

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque

data class Point(val z: Int, val y: Int, val x: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (m, n, h) = readLine().split(" ").map { it.toInt() }

    val box = Array(h) { Array(n) { IntArray(m) } }
    val dist = Array(h) { Array(n) { IntArray(m) { -1 } } }
    val q = ArrayDeque<Point>()

    for (z in 0 until h) {
        for (y in 0 until n) {
            val row = readLine().split(" ").map { it.toInt() }
            for (x in 0 until m) {
                box[z][y][x] = row[x]
                if (box[z][y][x] == 1) {
                    q.add(Point(z, y, x))
                    dist[z][y][x] = 0
                }
            }
        }
    }

    val dz = intArrayOf(0, 0, 0, 0, 1, -1)
    val dy = intArrayOf(-1, 1, 0, 0, 0, 0)
    val dx = intArrayOf(0, 0, -1, 1, 0, 0)

    while (q.isNotEmpty()) {
        val (cz, cy, cx) = q.removeFirst()
        for (dir in 0 until 6) {
            val nz = cz + dz[dir]
            val ny = cy + dy[dir]
            val nx = cx + dx[dir]

            if (nz !in 0 until h || ny !in 0 until n || nx !in 0 until m) continue
            if (box[nz][ny][nx] != 0) continue
            if (dist[nz][ny][nx] != -1) continue

            box[nz][ny][nx] = 1
            dist[nz][ny][nx] = dist[cz][cy][cx] + 1
            q.add(Point(nz, ny, nx))
        }
    }

    var ans = 0
    for (z in 0 until h) {
        for (y in 0 until n) {
            for (x in 0 until m) {
                if (box[z][y][x] == 0) {
                    println(-1)
                    return@with
                }
                if (dist[z][y][x] > ans) ans = dist[z][y][x]
            }
        }
    }
    println(ans)
}