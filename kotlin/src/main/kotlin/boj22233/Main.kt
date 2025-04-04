package boj22233

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val set = mutableSetOf<String>()
    repeat(n) {
        set.add(readLine())
    }

    val result = buildString {
        repeat(m) {
            readLine().split(",").forEach {
                set.remove(it)
            }
            append(set.size)
            append("\n")
        }
    }

    println(result)
}