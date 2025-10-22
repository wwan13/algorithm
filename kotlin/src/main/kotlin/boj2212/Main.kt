package boj2212

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val k = readLine().toInt()
    val sensors = readLine().split(" ").map { it.toInt() }.sorted()

    if (k >= n) {
        println(0)
        return@with
    }

    val diffs = IntArray(n - 1) { i ->
        sensors[i + 1] - sensors[i]
    }

    val answer = diffs
        .sortedArrayDescending()
        .drop(k - 1)
        .sum()

    println(answer)
}