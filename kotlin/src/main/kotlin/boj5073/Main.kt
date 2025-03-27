package boj5073

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val list = readLine().split(" ").map { it.toInt() }
        if (list.all { it == 0 }) break

        val sortedList = list.sorted()
        when {
            sortedList[0] + sortedList[1] <= sortedList[2] -> println("Invalid")
            sortedList[0] == sortedList[1] && sortedList[1] == sortedList[2] -> println("Equilateral")
            sortedList[0] == sortedList[1] || sortedList[1] == sortedList[2] -> println("Isosceles")
            else -> println("Scalene")
        }
    }
}
