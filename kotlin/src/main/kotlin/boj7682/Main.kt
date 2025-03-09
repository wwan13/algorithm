package boj7682

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val input = readLine()
        if (input == "end") break

        val board = input.toCharArray()
        val countX = board.count { it == 'X' }
        val countO = board.count { it == 'O' }

        if (countX < countO || countX > countO + 1) {
            println("invalid")
            continue
        }

        val winPatterns = listOf(
            listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), // 가로
            listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8), // 세로
            listOf(0, 4, 8), listOf(2, 4, 6)  // 대각선
        )

        val xWin = winPatterns.any { pattern -> pattern.all { board[it] == 'X' } }
        val oWin = winPatterns.any { pattern -> pattern.all { board[it] == 'O' } }

        if (xWin && oWin) {
            println("invalid")
            continue
        }

        if (xWin && countX == countO + 1) {
            println("valid")
            continue
        }

        if (oWin && countX == countO) {
            println("valid")
            continue
        }

        if (!xWin && !oWin && board.none { it == '.' }) {
            println("valid")
            continue
        }

        println("invalid")
    }
}
