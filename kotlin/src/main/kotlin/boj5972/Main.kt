package boj5972

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(m) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b to c)
        graph[b].add(a to c)
    }

    val visited = BooleanArray(n + 1) { false }
    val distance = IntArray(n + 1) { Int.MAX_VALUE }

    fun dijkstra() {
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        visited[1] = true
        distance[1] = 0
        pq.offer(1 to 0)

        while (pq.isNotEmpty()) {
            val (current, currentDistance) = pq.poll()

            graph[current].forEach { (next, nextDistance) ->
                val newDistance = currentDistance + nextDistance
                if (distance[next] > newDistance) {
                    distance[next] = newDistance
                    pq.offer(next to newDistance)
                }
            }
        }
    }

    dijkstra()

    println(distance[n])
}