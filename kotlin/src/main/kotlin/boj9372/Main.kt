package boj9372

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        repeat(m) {
            readLine()
        }

        println(n - 1)
    }
}