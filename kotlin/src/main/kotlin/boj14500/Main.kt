package boj14500

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    val visited = Array(n) { BooleanArray(m) }
    var maxSum = 0

    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)

    fun dfs(x: Int, y: Int, depth: Int, sum: Int) {
        if (depth == 4) {
            maxSum = maxOf(maxSum, sum)
            return
        }

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until n && ny in 0 until m && !visited[nx][ny]) {
                visited[nx][ny] = true
                dfs(nx, ny, depth + 1, sum + map[nx][ny])
                visited[nx][ny] = false
            }
        }
    }

    fun checkExtraShape(x: Int, y: Int) {
        val shapes = arrayOf(
            arrayOf(0 to 0, 0 to 1, 0 to 2, 1 to 1),
            arrayOf(0 to 1, 1 to 0, 1 to 1, 2 to 1),
            arrayOf(1 to 0, 1 to 1, 1 to 2, 0 to 1),
            arrayOf(0 to 0, 1 to 0, 2 to 0, 1 to 1)
        )

        for (shape in shapes) {
            var sum = 0
            var isValid = true

            for ((dx, dy) in shape) {
                val nx = x + dx
                val ny = y + dy
                if (nx !in 0 until n || ny !in 0 until m) {
                    isValid = false
                    break
                }
                sum += map[nx][ny]
            }

            if (isValid) {
                maxSum = maxOf(maxSum, sum)
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            visited[i][j] = true
            dfs(i, j, 1, map[i][j])
            visited[i][j] = false

            checkExtraShape(i, j)
        }
    }

    println(maxSum)
}