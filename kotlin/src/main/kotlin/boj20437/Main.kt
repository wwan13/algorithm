package boj20437

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val w = readLine()
        val k = readLine().toInt()

        val charIndexes = mutableMapOf<Char, MutableList<Int>>()
        for (i in w.indices) {
            charIndexes.getOrPut(w[i]) { mutableListOf() }.add(i)
        }

        var minLen = Int.MAX_VALUE
        var maxLen = Int.MIN_VALUE

        for ((_, indexes) in charIndexes) {
            if (indexes.size < k) continue

            for (i in 0..indexes.size - k) {
                val length = indexes[i + k - 1] - indexes[i] + 1
                minLen = minOf(minLen, length)
                maxLen = maxOf(maxLen, length)
            }
        }

        if (minLen == Int.MAX_VALUE) {
            println(-1)
        } else {
            println("$minLen $maxLen")
        }
    }
}
