package boj2573

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    var years = 0

    while (!allClear(map)) {
        var count = 0
        val visited = Array(n) { BooleanArray(m) { false } }

        for (i in 1 until n - 1) {
            for (j in 1 until m - 1) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(map, visited, i, j, n, m)
                    count++
                }
            }
        }

        if (count >= 2) {
            print(years)
            return
        }

        years += 1
        nextYear(map, n, m)
    }

    print(0)
}

fun bfs(map: Array<IntArray>, visited: Array<BooleanArray>, sx: Int, sy: Int, n: Int, m: Int) {
    val q: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
    visited[sx][sy] = true
    q.add(Pair(sx, sy))

    while (q.isNotEmpty()) {
        val (x, y) = q.removeFirst()
        for (k in 0 until 4) {
            val nx = x + dx[k]
            val ny = y + dy[k]
            if (nx !in 0 until n || ny !in 0 until m) continue
            if (!visited[nx][ny] && map[nx][ny] > 0) {
                visited[nx][ny] = true
                q.add(nx to ny)
            }
        }
    }
}

fun nextYear(map: Array<IntArray>, n: Int, m: Int) {
    val melt = Array(n) { IntArray(m) }

    for (i in 1 until n - 1) {
        for (j in 1 until m - 1) {
            if (map[i][j] == 0) continue
            var sea = 0
            for (k in 0 until 4) {
                val nx = i + dx[k]
                val ny = j + dy[k]
                if (map[nx][ny] == 0) sea++
            }
            melt[i][j] = sea
        }
    }

    for (i in 1 until n - 1) {
        for (j in 1 until m - 1) {
            if (map[i][j] > 0) {
                map[i][j] = (map[i][j] - melt[i][j]).coerceAtLeast(0)
            }
        }
    }
}

fun allClear(map: Array<IntArray>) = map.all { row -> row.all { it == 0 } }