package boj4358

import java.util.TreeMap

fun main() = with(System.`in`.bufferedReader()) {
    val map = TreeMap<String, Int>(compareBy { it })
    var total = 0

    while (true) {
        val tree = readLine() ?: break

        map[tree] = map.getOrDefault(tree, 0) + 1
        total++
    }

    for ((tree, count) in map) {
        val percent = count * 100.0 / total
        println(String.format("%s %.4f", tree, percent))
    }
}