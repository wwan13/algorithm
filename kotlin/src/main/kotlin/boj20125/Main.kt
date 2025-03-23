package boj20125

const val BODY = '*'

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val cookies = Array(n) { readLine().toCharArray() }

    fun findHeart(): Pair<Int, Int> {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (cookies[i][j] == BODY) {
                    return i + 1 to j
                }
            }
        }
        return -1 to -1
    }

    val (heartRow, heartCol) = findHeart()

    // 왼팔
    var leftArm = 0
    for (j in heartCol - 1 downTo 0) {
        if (cookies[heartRow][j] == BODY) leftArm++ else break
    }

    // 오른팔
    var rightArm = 0
    for (j in heartCol + 1 until n) {
        if (cookies[heartRow][j] == BODY) rightArm++ else break
    }

    // 허리
    var waist = 0
    var waistEndRow = heartRow
    for (i in heartRow + 1 until n) {
        if (cookies[i][heartCol] == BODY) {
            waist++
            waistEndRow = i
        } else break
    }

    // 왼다리
    var leftLeg = 0
    for (i in waistEndRow + 1 until n) {
        if (cookies[i][heartCol - 1] == BODY) leftLeg++ else break
    }

    // 오른다리
    var rightLeg = 0
    for (i in waistEndRow + 1 until n) {
        if (cookies[i][heartCol + 1] == BODY) rightLeg++ else break
    }

    println("${heartRow + 1} ${heartCol + 1}")
    println("$leftArm $rightArm $waist $leftLeg $rightLeg")
}
