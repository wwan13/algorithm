package boj25757

fun main() = with(System.`in`.bufferedReader()) {
    val (n, type) = readLine().split(" ")
    val players = mutableSetOf<String>()

    repeat(n.toInt()) {
        val player = readLine()
        players.add(player)
    }

    val div = when (type) {
        "Y" -> 2
        "F" -> 3
        "O" -> 4
        else -> -1
    }
    println(players.size / (div - 1))
}