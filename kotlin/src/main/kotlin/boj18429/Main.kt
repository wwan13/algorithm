package boj18429

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val kits = readLine().split(" ").map { it.toInt() }

    val visited = BooleanArray(n) { false }
    var count = 0

    fun backtracking(day: Int, weight: Int) {
        if (day == n) {
            count++
            return
        }

        for (i in kits.indices) {
            if (!visited[i]) {
                val newWeight = weight - k + kits[i]
                if (newWeight >= 500) {
                    visited[i] = true
                    backtracking(day + 1, newWeight)
                    visited[i] = false
                }
            }
        }
    }

    backtracking(0, 500)
    println(count)
}