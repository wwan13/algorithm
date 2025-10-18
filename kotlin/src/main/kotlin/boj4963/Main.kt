package boj4963

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val (w, h) = readLine().split(' ').map { it.toInt() }
        if (w == 0 && h == 0) break

        val map = List(h) { readLine().split(' ').map { it.toInt() } }
        val visited = Array(h) { BooleanArray(w) }

        val dx = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
        val dy = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

        var count = 0
        for (y in 0 until h) {
            for (x in 0 until w) {
                if (map[y][x] == 1 && !visited[y][x]) {
                    count++
                    val queue = ArrayDeque<Pair<Int, Int>>()
                    queue.add(y to x)
                    visited[y][x] = true

                    while (queue.isNotEmpty()) {
                        val (cy, cx) = queue.removeFirst()

                        for (dir in 0 until 8) {
                            val ny = cy + dy[dir]
                            val nx = cx + dx[dir]

                            if (ny !in 0 until h || nx !in 0 until w) continue
                            if (map[ny][nx] == 0 || visited[ny][nx]) continue

                            visited[ny][nx] = true
                            queue.add(ny to nx)
                        }
                    }
                }
            }
        }
        println(count)
    }
}