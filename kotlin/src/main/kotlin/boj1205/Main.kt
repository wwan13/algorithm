package boj1205

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, score, p) = readLine().split(" ").map { it.toLong() }

    if (n == 0L) {
        println(1)
        return
    }

    val scores = readLine().split(" ").map { it.toLong() }

    val priorityQueue = PriorityQueue<Long>(compareByDescending { it })
    scores.forEach { priorityQueue.offer(it) }

    if (n >= p && score <= priorityQueue.minOrNull()!!) {
        println(-1)
        return
    }

    var rank = 1
    for (top in priorityQueue) {
        if (score >= top) break
        rank++
    }

    println(rank)
}
