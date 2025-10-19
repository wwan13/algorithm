package boj7562

// bfs
fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val l = readLine().toInt()
        val (startX, startY) = readLine().split(" ").map { it.toInt() }
        val (endX, endY) = readLine().split(" ").map { it.toInt() }

        if (startX == endX && startY == endY) {
            println(0)
            return@repeat
        }

        val dist = Array(l) { IntArray(l) { -1 } }
        val stack = ArrayDeque<Pair<Int, Int>>()

        val dx = intArrayOf(2, 2, 1, 1, -1, -1, -2, -2)
        val dy = intArrayOf(1, -1, 2, -2, 2, -2, 1, -1)

        dist[startX][startY] = 0
        stack.addLast(startX to startY)

        while (stack.isNotEmpty()) {
            val (x, y) = stack.removeFirst()
            if (x == endX && y == endY) break

            for (k in 0 until 8) {
                val nx = x + dx[k]
                val ny = y + dy[k]
                if (nx in 0 until l && ny in 0 until l && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1
                    stack.addLast(nx to ny)
                }
            }
        }

        println(dist[endX][endY])
    }
}