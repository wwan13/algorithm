package boj17266

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }

    var left = 0
    var right = n
    var answer = n

    while (left <= right) {
        val mid = (left + right) / 2
        var isCovered = true
        var prev = 0

        for (pos in arr) {
            if (pos - mid > prev) {
                isCovered = false
                break
            }
            prev = pos + mid
        }

        if (prev < n) isCovered = false

        if (isCovered) {
            answer = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    println(answer)
}
