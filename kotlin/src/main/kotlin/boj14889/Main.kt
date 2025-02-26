package boj14889

import kotlin.math.abs

lateinit var abilities: Array<IntArray>
lateinit var visited: BooleanArray
var minDiff = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    abilities = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = BooleanArray(n)

    backTracking(n, 0, 0)
    println(minDiff)
}

private fun backTracking(n: Int, current: Int, depth: Int) {
    if (depth == n / 2) {
        var team1 = 0
        var team2 = 0

        for (i in 0..<n) {
            for (j in 0..<n) {
                if (visited[i] && visited[j]) {
                    team1 += abilities[i][j]
                } else if (!visited[i] && !visited[j]) {
                    team2 += abilities[i][j]
                }
            }
        }
        minDiff = minOf(minDiff, abs(team1 - team2))
        return
    }

    for (i in current..<n) {
        if (!visited[i]) {
            visited[i] = true
            backTracking(n, i + 1, depth + 1)
            visited[i] = false
        }
    }
}