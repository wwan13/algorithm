package boj20055

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val belts = readLine().split(" ").map { it.toInt() }.toMutableList()
    val robots = BooleanArray(n) { false }

    var step = 0
    do {
        step++

        // 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
        val lastBelt = belts.removeLast()
        belts.add(0, lastBelt)

        for (i in n - 2 downTo 0) {
            robots[i + 1] = robots[i]
        }
        robots[0] = false
        robots[n - 1] = false

        // 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
        for (i in n - 2 downTo 0) {
            // 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            if (robots[i] && !robots[i + 1] && belts[i + 1] > 0) {
                robots[i] = false
                robots[i + 1] = true
                belts[i + 1]--
            }
        }
        robots[n - 1] = false

        // 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
        if (belts[0] > 0) {
            robots[0] = true
            belts[0]--
        }
    } while (belts.count { it == 0 } < k) // 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.

    println(step)
}