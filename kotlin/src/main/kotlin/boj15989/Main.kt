package boj15989

fun main() = with(System.`in`.bufferedReader()) {
    val dp = Array(10001) { IntArray(4) }

    dp[0][1] = 1
    dp[0][2] = 0
    dp[0][3] = 0

    for (i in 1..10000) {
        dp[i][1] = dp[i - 1][1]
        if (i >= 2) dp[i][2] = dp[i - 2][1] + dp[i - 2][2]
        if (i >= 3) dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3]
    }

    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        println(dp[n][1] + dp[n][2] + dp[n][3])
    }
}