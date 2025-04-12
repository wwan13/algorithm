package boj3758

data class Team(
    val id: Int,
    val scores: IntArray,
    var totalScore: Int = 0,
    var submitCount: Int = 0,
    var lastSubmitTime: Int = 0
)

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        val (n, k, myId, m) = readLine().split(" ").map { it.toInt() }

        val teams = Array(n + 1) { Team(it, IntArray(k + 1)) }

        repeat(m) { time ->
            val (i, j, s) = readLine().split(" ").map { it.toInt() }

            val team = teams[i]
            team.submitCount++
            team.lastSubmitTime = time

            if (s > team.scores[j]) {
                team.totalScore += (s - team.scores[j])
                team.scores[j] = s
            }
        }

        val sorted = teams
            .filter { it.id != 0 }
            .sortedWith(compareByDescending<Team> { it.totalScore }
                .thenBy { it.submitCount }
                .thenBy { it.lastSubmitTime })

        val rank = sorted.indexOfFirst { it.id == myId } + 1
        println(rank)
    }
}