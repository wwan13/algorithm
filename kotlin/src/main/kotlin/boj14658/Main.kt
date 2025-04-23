package boj14658

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, l, k) = readLine().split(" ").map { it.toInt() }

    val stars = mutableListOf<Pair<Int, Int>>()

    repeat(k) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        stars.add(x to y)
    }

    var answer = 0

    for ((sx, sy) in stars) {
        for ((ex, ey) in stars) {
            val x1 = sx
            val y1 = ey

            var cnt = 0

            for ((x, y) in stars) {
                if (x1 <= x && x <= x1 + l && y1 <= y && y <= y1 + l) {
                    cnt++
                }
            }
            answer = maxOf(answer, cnt)
        }
    }

    println(k - answer)
}
