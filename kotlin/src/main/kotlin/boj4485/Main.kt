package boj4485

import java.util.PriorityQueue

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

data class Node(val x: Int, val y: Int, val cost: Int)

fun main() = with(System.`in`.bufferedReader()) {
    var t = 1
    while (true) {
        val n = readLine().toInt()
        if (n == 0) break

        val map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
        val costs = Array(n) { IntArray(n) { Int.MAX_VALUE } }

        fun dijkstra() {
            val pq: PriorityQueue<Node> = PriorityQueue(compareBy { it.cost })
            pq.offer(Node(0, 0, map[0][0]))

            while (pq.isNotEmpty()) {
                val (x, y, cost) = pq.poll()

                for (i in 0..<4) {
                    val nx = x + dx[i]
                    val ny = y + dy[i]

                    if (nx in 0..<n && ny in 0..<n) {
                        val nextCost = cost + map[nx][ny]
                        if (nextCost < costs[nx][ny]) {
                            costs[nx][ny] = nextCost
                            pq.offer(Node(nx, ny, nextCost))
                        }
                    }
                }
            }
        }

        dijkstra()
        println("Problem ${t}: ${costs[n - 1][n - 1]}")

        t += 1
    }
}