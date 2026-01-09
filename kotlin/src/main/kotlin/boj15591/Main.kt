package boj15591

fun main() = with(System.`in`.bufferedReader()) {
    val (n, q) = readLine().split(" ").map { it.toInt() }

    val nodes = Array(n + 1) { mutableListOf<Pair<Int, Int>>() }

    repeat(n - 1) {
        val (p, q, r) = readLine().split(" ").map { it.toInt() }
        nodes[p].add(q to r)
        nodes[q].add(p to r)
    }

    fun bfs(start: Int, k: Int): Int {
        val visited = BooleanArray(n + 1)
        val queue = ArrayDeque<Pair<Int, Int>>()

        visited[start] = true
        queue.add(start to Int.MAX_VALUE)

        var cnt = 0

        while (queue.isNotEmpty()) {
            val (current, currentMin) = queue.removeFirst()

            for ((next, nextDistance) in nodes[current]) {
                if (visited[next]) continue

                val nextMin = minOf(currentMin, nextDistance)
                if (nextMin >= k) {
                    cnt++
                    visited[next] = true
                    queue.add(next to nextMin)
                }
            }
        }
        return cnt
    }

    repeat(q) {
        val (k, v) = readLine().split(" ").map { it.toInt() }
        bfs(v, k)
        println(bfs(v, k))
    }
}