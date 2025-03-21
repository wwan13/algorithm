package boj10431

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) { t ->
        val input = readLine().split(" ").map { it.toInt() }
        val testCase = input[0]
        val heights = input.drop(1)

        var moves = 0
        val sortedList = mutableListOf<Int>()

        for (height in heights) {
            var index = sortedList.size
            while (index > 0 && sortedList[index - 1] > height) {
                index--
            }
            moves += sortedList.size - index
            sortedList.add(index, height)
        }

        println("$testCase $moves")
    }
}