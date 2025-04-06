package boj1522

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val n = s.length
    val aCount = s.count { it == 'a' }

    val doubled = s + s

    var minSwap = Int.MAX_VALUE
    var currentB = 0

    for (i in 0 until aCount) {
        if (doubled[i] == 'b') currentB++
    }
    minSwap = currentB

    for (i in 1 until n) {
        if (doubled[i - 1] == 'b') currentB--
        if (doubled[i + aCount - 1] == 'b') currentB++
        minSwap = minOf(minSwap, currentB)
    }

    println(minSwap)
}
