package boj2138

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val initial = readLine().toCharArray()
    val target = readLine().toCharArray()

    fun solve(arr: CharArray, countStart: Int): Int {
        var count = countStart

        for (i in 0 until n - 1) {
            if (arr[i] != target[i]) {
                arr.toggle(i + 1)
                count++
            }
        }

        return if (arr.contentEquals(target)) count else -1
    }

    val firstToggleCase = initial.clone()
    firstToggleCase.toggle(0)
    val result1 = solve(firstToggleCase, 1)

    val notToggleCase = initial.clone()
    val result2 = solve(notToggleCase, 0)

    val answer = listOf(result1, result2).filter { it != -1 }.minOrNull() ?: -1
    println(answer)
}

private fun CharArray.toggle(index: Int) {
    for (i in index - 1..index + 1) {
        if (i in this.indices) {
            this[i] = if (this[i] == '0') '1' else '0'
        }
    }
}