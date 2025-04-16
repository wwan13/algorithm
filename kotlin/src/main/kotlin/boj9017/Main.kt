package boj9017

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        val n = readLine().toInt()
        val scores = readLine().split(" ").map { it.toInt() }
        val maxTeam = scores.maxOrNull() ?: 0

        // 팀별 참가자 수 세기
        val teamCnt = IntArray(maxTeam + 1)
        for (i in 0 until n) {
            teamCnt[scores[i]]++
        }

        val recordTeams = mutableSetOf<Int>()
        for (i in teamCnt.indices) {
            if (teamCnt[i] == 6) {
                recordTeams.add(i)
            }
        }

        val record = Array(maxTeam + 1) { Pair(0, mutableListOf<Int>()) }

        var score = 0
        for (i in 0 until n) {
            val team = scores[i]
            if (team in recordTeams) {
                score++
                val (count, list) = record[team]
                if (count < 5) {
                    list.add(score)
                    record[team] = Pair(count + 1, list)
                }
            }
        }

        var result = 0
        var minScore = Int.MAX_VALUE
        for (i in record.indices) {
            val (count, list) = record[i]
            if (count == 0) continue

            val sum = list.take(4).sum()
            if (sum < minScore) {
                minScore = sum
                result = i
            } else if (sum == minScore) {
                if (list[4] < record[result].second[4]) {
                    result = i
                }
            }
        }

        println(result)
    }
}
