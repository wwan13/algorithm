package boj1138

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val heights = readLine().split(" ").map { it.toInt() }

    val result = MutableList(n) { 0 }

    for (i in 0 until n) {
        val count = heights[i]
        var empty = 0
        for (j in 0 until n) {
            if (result[j] == 0) {
                if (empty == count) {
                    result[j] = i + 1
                    break
                }
                empty++
            }
        }
    }

    println(result.joinToString(" "))
}