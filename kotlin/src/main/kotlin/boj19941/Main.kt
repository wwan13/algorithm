package boj19941

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val line = readLine().toCharArray()
    val ate = BooleanArray(n) { false }
    var count = 0

    for (i in 0 until n) {
        if (line[i] == 'P') {
            val start = maxOf(0, i - k)
            val end = minOf(n - 1, i + k)

            for (j in start..end) {
                if (line[j] == 'H' && !ate[j]) {
                    ate[j] = true
                    count++
                    break
                }
            }
        }
    }

    println(count)
}
