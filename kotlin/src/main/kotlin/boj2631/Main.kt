package boj2631

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val children = IntArray(n)
    val dp = IntArray(n)

    for (i in 0 until n) {
        children[i] = readLine().toInt()
    }

    for (i in 0 until n) {
        dp[i] = 1
        for (j in 0 until i) {
            if (children[j] < children[i] && dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1
            }
        }
    }

    println(n - dp.maxOrNull()!!)
}