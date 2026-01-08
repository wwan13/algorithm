package boj13335

fun main() = with(System.`in`.bufferedReader()) {
    val (n, w, l) = readLine().split(" ").map { it.toInt() }
    val trucks = readLine().split(" ").map { it.toInt() }.toIntArray()

    val queue = ArrayDeque<Int>(w)
    repeat(w) { queue.addLast(0) }

    var count = 0
    var weight = 0
    var idx = 0

    while (idx < n) {
        weight -= queue.removeFirst()

        val next = trucks[idx]
        if (weight + next <= l) {
            // 올라갈 수 있는 경우
            queue.addLast(next)
            weight += next
            idx++
        } else {
            // 못올라가는 경우
            queue.addLast(0)
        }

        count++
    }

    println(count + w)
}