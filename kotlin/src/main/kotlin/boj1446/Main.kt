package boj1446

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, d) = readLine().split(" ").map { it.toInt() }

    val graph = Array(d + 1) { mutableListOf<Pair<Int, Int>>() }

    for (i in 0 until d) {
        graph[i].add(i + 1 to 1)
    }

    repeat(n) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        if (b <= d) graph[a].add(b to c)
    }

    val distances = IntArray(d + 1) { Int.MAX_VALUE }

    fun dijkstra() {
        val pq = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
        pq.offer(0 to 0)
        distances[0] = 0

        while (pq.isNotEmpty()) {
            val (current, currentDistance) = pq.poll()
            
            if (currentDistance > distances[current]) continue

            for ((next, nextDistance) in graph[current]) {
                val newDistance = currentDistance + nextDistance

                if (newDistance < distances[next]) {
                    distances[next] = newDistance
                    pq.offer(next to newDistance)
                }
            }
        }
    }

    dijkstra()
    println(distances[d])
}
