package boj18352

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k, x) = readLine().split(" ").map { it.toInt() }

    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        graph[start].add(end)
    }

    val distances = IntArray(n + 1) { -1 }
    val queue = ArrayDeque<Int>()

    distances[x] = 0
    queue.add(x)

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        for (next in graph[current]) {
            if (distances[next] == -1) {
                distances[next] = distances[current] + 1
                queue.add(next)
            }
        }
    }

    val result = mutableListOf<Int>()
    for (city in 1..n) {
        if (distances[city] == k) {
            result.add(city)
        }
    }

    if (result.isEmpty()) {
        println("-1")
    } else {
        result.forEach {
            println(it)
        }
    }
}