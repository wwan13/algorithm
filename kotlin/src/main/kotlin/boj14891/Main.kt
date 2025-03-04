package boj14891

fun main() = with(System.`in`.bufferedReader()) {
    val gears = Array(4) { readLine() }

    val n = readLine().toInt()
    repeat(n) {
        val (gearNum, direction) = readLine().split(" ").map { it.toInt() }
        val gearIdx = gearNum - 1

        val directions = IntArray(4)
        directions[gearIdx] = direction

        for (i in gearIdx - 1 downTo 0) {
            if (gears[i][2] != gears[i + 1][6]) {
                directions[i] = -directions[i + 1]
            } else {
                break
            }
        }

        for (i in gearIdx + 1..<4) {
            if (gears[i - 1][2] != gears[i][6]) {
                directions[i] = -directions[i - 1]
            } else {
                break
            }
        }

        for (i in 0..<4) {
            if (directions[i] != 0) {
                gears[i] = if (directions[i] == 1) {
                    gears[i].last() + gears[i].substring(0, gears[i].length - 1)
                } else {
                    gears[i].substring(1) + gears[i].first()
                }
            }
        }
    }

    var answer = 0
    for (i in 0..<4) {
        val target = gears[i].first()
        if (target == '1') {
            answer += when (i) {
                0 -> 1
                1 -> 2
                2 -> 4
                else -> 8
            }
        }
    }

    println(answer)
}