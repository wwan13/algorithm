package boj1189

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c, k) = readLine().split(" ").map { it.toInt() }
    val map = Array(r) { readLine().toCharArray() }

    val startX = 0
    val startY = r - 1
    val homeX = c - 1
    val homeY = 0

    val visited = Array(r) { BooleanArray(c) }
    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1)

    var count = 0

    fun dfs(x: Int, y: Int, dist: Int) {
        if (dist == k) {
            if (x == homeX && y == homeY) count++
            return
        }

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0 until c || ny !in 0 until r) continue
            if (map[ny][nx] == 'T') continue
            if (visited[ny][nx]) continue

            visited[ny][nx] = true
            dfs(nx, ny, dist + 1)
            visited[ny][nx] = false
        }
    }

    visited[startY][startX] = true
    dfs(startX, startY, 1)

    print(count)
}