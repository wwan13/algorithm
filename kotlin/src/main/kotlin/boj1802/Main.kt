package boj1802

import java.util.ArrayDeque

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        val s = readLine().trim().toCharArray()
        val stack = ArrayDeque<Pair<Int, Int>>()
        stack.addLast(0 to s.lastIndex)

        var ok = true

        while (stack.isNotEmpty() && ok) {
            val (left, right) = stack.removeLast()
            val len = right - left + 1

            if (len == 1) continue
            if (len % 2 == 0) {
                ok = false
                break
            }

            val mid = (left + right) / 2

            var i = 0
            while (left + i < mid) {
                if (s[left + i] == s[right - i]) {
                    ok = false
                    break
                }
                i++
            }
            if (!ok) break

            // 좌/우 구간 계속 검사
            stack.addLast(left to (mid - 1))
            stack.addLast((mid + 1) to right)
        }

        println(if (ok) "YES" else "NO")
    }
}