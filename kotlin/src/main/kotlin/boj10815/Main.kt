package boj10815

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toLong()
    val cards = readLine().split(" ").map { it.toLong() }.toSet()
    val m = readLine().toInt()
    val numbers = readLine().split(" ").map { it.toLong() }

    val result = numbers.joinToString(" ") { n ->
        if (n in cards) "1"
        else "0"
    }
    println(result)
}