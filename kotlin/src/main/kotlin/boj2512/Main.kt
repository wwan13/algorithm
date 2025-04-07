package boj2512

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val moneys = readLine().split(" ").map { it.toInt() }
    val total = readLine().toInt()

    var left = 0
    var right = moneys.maxOrNull() ?: 0
    var answer = 0

    while (left <= right) {
        val mid = (left + right) / 2
        val sum = moneys.sumOf { if (it > mid) mid else it }

        if (sum <= total) {
            answer = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(answer)
}
