package boj3190

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val k = readLine().toInt()

    val apples = mutableSetOf<Pair<Int, Int>>()
    repeat(k) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        apples.add(x - 1 to y - 1)
    }

    val l = readLine().toInt()
    val directions = mutableMapOf<Int, Char>()
    repeat(l) {
        val (t, d) = readLine().split(" ")
        directions[t.toInt()] = d.first()
    }

    val dx = listOf(0, 1, 0, -1)
    val dy = listOf(1, 0, -1, 0)
    var dir = 0

    var time = 0
    var x = 0
    var y = 0
    val snake: Deque<Pair<Int, Int>> = LinkedList()
    snake.addFirst(0 to 0)

    while (true) {
        time++

        val nx = x + dx[dir]
        val ny = y + dy[dir]

        if (nx !in 0..<n || ny !in 0..<n || (nx to ny) in snake) break

        snake.addFirst(nx to ny)

        if (nx to ny in apples) {
            apples.remove(nx to ny)
        } else {
            snake.removeLast()
        }

        if (time in directions) {
            dir = when (directions[time]) {
                'L' -> (dir + 3) % 4
                'D' -> (dir + 1) % 4
                else -> dir
            }
        }

        x = nx
        y = ny
    }

    println(time)
}
