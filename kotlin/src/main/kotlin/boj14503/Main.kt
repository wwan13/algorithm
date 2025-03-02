package boj14503

val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val (r, c, d) = readLine().split(" ").map { it.toInt() }

    val map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    var x = r
    var y = c
    var direction = d
    var count = 0

    while (true) {
        if (map[x][y] == 0) {
            map[x][y] = 2
            count += 1
        }

        var cleaned = false
        for (i in 0..3) {
            direction = (direction + 3) % 4
            val nx = x + dx[direction]
            val ny = y + dy[direction]

            if (nx in 0..<n && ny in 0..<m && map[nx][ny] == 0) {
                x = nx
                y = ny
                cleaned = true
                break
            }
        }

        if (!cleaned) {
            val backX = x - dx[direction]
            val backY = y - dy[direction]

            if (backX in 0..<n && backY in 0..<m && map[backX][backY] != 1) {
                x = backX
                y = backY
            } else {
                break
            }
        }
    }

    println(count)
}
