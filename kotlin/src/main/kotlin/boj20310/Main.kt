package boj20310

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()

    val zeroCount = s.count { it == '0' } / 2
    val oneCount = s.count { it == '1' } / 2

    var oneRemoveCount = 0
    val oneRemove = buildString {
        for (c in s) {
            if (c == '1' && oneRemoveCount < oneCount) {
                oneRemoveCount += 1
            } else {
                append(c)
            }
        }
    }

    var removeZeroCount = 0
    buildString {
        for (i in oneRemove.length - 1 downTo 0) {
            if (oneRemove[i] == '0' && removeZeroCount < zeroCount) {
                removeZeroCount += 1
            } else {
                append(oneRemove[i])
            }
        }
    }.let {
        println(it.reversed())
    }
}