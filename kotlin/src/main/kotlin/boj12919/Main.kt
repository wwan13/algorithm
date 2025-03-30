package boj12919

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val t = readLine()

    fun backtracking(current: StringBuilder): Boolean {
        if (current.toString() == s) return true
        if (current.length < s.length) return false

        if (current.last() == 'A') {
            current.deleteAt(current.lastIndex)
            if (backtracking(current)) return true
            current.append('A')
        }

        if (current.first() == 'B') {
            current.reverse().deleteAt(current.lastIndex)
            if (backtracking(current)) return true
            current.append('B').reverse()
        }

        return false
    }

    println(if (backtracking(StringBuilder(t))) 1 else 0)
}
