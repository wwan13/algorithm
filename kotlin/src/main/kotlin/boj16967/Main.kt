package boj16967

fun main() = with(System.`in`.bufferedReader()) {
    val (h, w, x, y) = readLine().trim().split(" ").map { it.toInt() }

    val b = Array(h + x) {
        readLine().trim().split(" ").map { it.toInt() }.toIntArray()
    }

    val a = Array(h) { IntArray(w) }

    for (i in 0 until h) {
        for (j in 0 until w) {
            try {
                a[i][j] = b[i][j] - a[i - x][j - y]
            } catch (e: IndexOutOfBoundsException) {
                a[i][j] = b[i][j]
            }
        }
    }

    for (i in 0 until h) {
        println(a[i].joinToString(" "))
    }
}