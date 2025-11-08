package boj1269

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().split(" ").map { it.toInt() }
    val setA = readLine().split(" ").map { it.toInt() }.toSet()
    val setB = readLine().split(" ").map { it.toInt() }.toSet()

    val first = setA - setB
    val second = setB - setA

    val result = first.size + second.size

    println(result)
}