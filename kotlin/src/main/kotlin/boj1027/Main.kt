package boj1027

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val buildings = readLine().split(" ").map { it.toLong() }

    var max = 0

    for (i in 0 until n) {
        val base = buildings[i]
        var count = 0
        for (j in 0 until n) {
            if (i == j) continue
            val target = buildings[j]

            val slope = (target - base).toDouble() / (j - i).toDouble()
            val yIntercept = base - slope * i

            var canSee = true
            for (k in minOf(i, j) + 1 until maxOf(i, j)) {
                val y = slope * k + yIntercept
                if (y <= buildings[k]) {
                    canSee = false
                    break
                }
            }
            if (canSee) count++
        }
        max = maxOf(max, count)
    }

    println(max)
}