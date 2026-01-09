package boj18428

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().trim().toInt()
    val board = Array(n) { CharArray(n) }
    val empties = ArrayList<Pair<Int, Int>>()
    val teachers = ArrayList<Pair<Int, Int>>()

    for (i in 0 until n) {
        val row = readLine().trim().split(" ")
        for (j in 0 until n) {
            val ch = row[j][0]
            board[i][j] = ch
            when (ch) {
                'X' -> empties.add(i to j)
                'T' -> teachers.add(i to j)
            }
        }
    }

    fun canHide(): Boolean {
        val dirs = arrayOf(
            -1 to 0, 1 to 0, 0 to -1, 0 to 1
        )

        for ((tx, ty) in teachers) {
            for (d in dirs) {
                var x = tx
                var y = ty

                // 끝까지 다 볼 수 있음
                while (true) {
                    x += d.first
                    y += d.second

                    if (x !in 0 until n || y !in 0 until n) break

                    // 장애물 뒤로는 못봄
                    if (board[x][y] == 'O') break

                    // 학생 걸림
                    if (board[x][y] == 'S') return false
                }
            }
        }

        return true
    }

    for (a in 0 until empties.size) {
        for (b in a + 1 until empties.size) {
            for (c in b + 1 until empties.size) {
                val (x1, y1) = empties[a]
                val (x2, y2) = empties[b]
                val (x3, y3) = empties[c]

                // 장애물 설치
                board[x1][y1] = 'O'
                board[x2][y2] = 'O'
                board[x3][y3] = 'O'

                if (canHide()) {
                    println("YES")
                    return@with
                }

                // 원위치
                board[x1][y1] = 'X'
                board[x2][y2] = 'X'
                board[x3][y3] = 'X'
            }
        }
    }

    println("NO")
}