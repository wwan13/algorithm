package boj22251

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k, p, x) = readLine().split(" ").map { it.toInt() }

    val ledSegments = listOf(
        listOf(1, 1, 1, 0, 1, 1, 1),
        listOf(0, 0, 1, 0, 0, 1, 0),
        listOf(1, 0, 1, 1, 1, 0, 1),
        listOf(1, 0, 1, 1, 0, 1, 1),
        listOf(0, 1, 1, 1, 0, 1, 0),
        listOf(1, 1, 0, 1, 0, 1, 1),
        listOf(1, 1, 0, 1, 1, 1, 1),
        listOf(1, 0, 1, 0, 0, 1, 0),
        listOf(1, 1, 1, 1, 1, 1, 1),
        listOf(1, 1, 1, 1, 0, 1, 1)
    )

    val origin = toDigitList(x, k)
    var count = 0

    for (target in 1..n) {
        if (target == x) continue

        val targetDigits = toDigitList(target, k)
        var totalDiff = 0

        for (i in 0 until k) {
            val originLED = ledSegments[origin[i]]
            val targetLED = ledSegments[targetDigits[i]]

            for (j in 0 until 7) {
                if (originLED[j] != targetLED[j]) {
                    totalDiff++
                }
            }
        }

        if (totalDiff <= p) {
            count++
        }
    }

    println(count)
}

private fun toDigitList(num: Int, length: Int): List<Int> {
    val str = num.toString().padStart(length, '0')
    return str.map { it - '0' }
}
