package boj19637

import java.util.TreeMap

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val treeMap = TreeMap<Long, String>()

    repeat(n) {
        val (name, power) = readLine().split(" ")
        val powerValue = power.toLong()
        if (!treeMap.containsKey(powerValue)) {
            treeMap[powerValue] = name
        }
    }

    val sb = StringBuilder()
    repeat(m) {
        val power = readLine().toLong()
        val key = treeMap.ceilingKey(power)
        sb.append(treeMap[key]).append("\n")
    }
    print(sb)
}
