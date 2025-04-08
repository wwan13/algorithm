package boj17615

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val balls = readLine().toCharArray()

    // R 왼쪽부터
    var leftRed = 0
    for (ball in balls) {
        if (ball == 'R') leftRed++
        else break
    }

    // R 오른쪽부터
    var rightRed = 0
    for (i in balls.lastIndex downTo 0) {
        if (balls[i] == 'R') rightRed++
        else break
    }

    // B 왼쪽부터
    var leftBlue = 0
    for (ball in balls) {
        if (ball == 'B') leftBlue++
        else break
    }

    // B 오른쪽부터
    var rightBlue = 0
    for (i in balls.lastIndex downTo 0) {
        if (balls[i] == 'B') rightBlue++
        else break
    }

    val totalRed = balls.count { it == 'R' }
    val totalBlue = balls.count { it == 'B' }

    val minMove = listOf(
        totalRed - leftRed,
        totalRed - leftRed,
        totalBlue - leftBlue,
        totalBlue - rightBlue
    ).min()

    println(minMove)
}
