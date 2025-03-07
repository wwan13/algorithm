package boj17144

val dx = intArrayOf(0, 0, 1, -1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c, t) = readLine().split(" ").map { it.toInt() }
    val map = Array(r) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    var upCleaner: Int = -1
    var downCleaner: Int = -1

    for (i in 0 until r) {
        if (map[i][0] == -1) {
            upCleaner = i
            downCleaner = i + 1
            break
        }
    }

    repeat(t) {
        val newMap = Array(r) { IntArray(c) { 0 } }

        for (i in 0 until r) {
            for (j in 0 until c) {
                if (map[i][j] > 0) {
                    val amount = map[i][j] / 5
                    var spreadCount = 0

                    for (d in 0..3) {
                        val nx = i + dx[d]
                        val ny = j + dy[d]
                        if (nx in 0 until r && ny in 0 until c && map[nx][ny] != -1) {
                            newMap[nx][ny] += amount
                            spreadCount++
                        }
                    }
                    newMap[i][j] += map[i][j] - (amount * spreadCount)
                }
            }
        }

        for (i in 0 until r) {
            for (j in 0 until c) {
                if (map[i][j] == -1) newMap[i][j] = -1
            }
        }

        for (i in 0 until r) {
            for (j in 0 until c) {
                map[i][j] = newMap[i][j]
            }
        }

        for (i in upCleaner - 1 downTo 1) map[i][0] = map[i - 1][0]
        for (i in 0 until c - 1) map[0][i] = map[0][i + 1]
        for (i in 0 until upCleaner) map[i][c - 1] = map[i + 1][c - 1]
        for (i in c - 1 downTo 1) map[upCleaner][i] = map[upCleaner][i - 1]
        map[upCleaner][1] = 0

        for (i in downCleaner + 1 until r - 1) map[i][0] = map[i + 1][0]
        for (i in 0 until c - 1) map[r - 1][i] = map[r - 1][i + 1]
        for (i in r - 1 downTo downCleaner + 1) map[i][c - 1] = map[i - 1][c - 1]
        for (i in c - 1 downTo 1) map[downCleaner][i] = map[downCleaner][i - 1]
        map[downCleaner][1] = 0
    }

    var result = 0
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (map[i][j] > 0) result += map[i][j]
        }
    }
    println(result)
}
