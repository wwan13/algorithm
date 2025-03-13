package boj2304

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val inputs = Array(n) { readLine().split(" ").map { it.toInt() } }

    val startPosition = inputs.minBy { it[0] }[0]
    val endPosition = inputs.maxBy { it[0] }[0]
    val maxHeightPosition = inputs.maxBy { it[1] }[0]

    val pillars = Array(endPosition + 1) { -1 }
    inputs.forEach { input ->
        pillars[input[0]] = input[1]
    }

    var result = 0
    var pillarHeight = -1

    for (i in startPosition..<maxHeightPosition) {
        if (pillars[i] > pillarHeight) {
            pillarHeight = pillars[i]
        }
        result += pillarHeight
    }

    pillarHeight = -1
    for (i in endPosition downTo maxHeightPosition) {
        if (pillars[i] > pillarHeight) {
            pillarHeight = pillars[i]
        }
        result += pillarHeight
    }

    println(result)
}