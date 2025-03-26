package boj17484

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(' ').map { it.toInt() }
    val map = Array(n) { readLine().split(' ').map { it.toInt() } }
    val dx = intArrayOf(1, 1, 1)
    val dy = intArrayOf(0, 1, -1)
    var answer = Int.MAX_VALUE

    fun dfs(x: Int, y: Int, prevDir: Int, sum: Int) {
        if (x == n - 1) {
            answer = minOf(answer, sum)
            return
        }

        for (dir in 0 until 3) {
            if (dir == prevDir) continue
            val nx = x + dx[dir]
            val ny = y + dy[dir]

            if (nx in 0 until n && ny in 0 until m) {
                dfs(nx, ny, dir, sum + map[nx][ny])
            }
        }
    }

    for (j in 0 until m) {
        dfs(0, j, -1, map[0][j])
    }

    println(answer)
}
