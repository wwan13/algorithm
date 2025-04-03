package boj7490

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()

    repeat(t) {
        val n = readLine().toInt()
        val operators = CharArray(n - 1) { ' ' }
        val results = mutableListOf<String>()

        fun backtracking(depth: Int) {
            if (depth == n - 1) {
                val expression = buildString {
                    append(1)
                    for (i in 2..n) {
                        append(operators[i - 2])
                        append(i)
                    }
                }

                if (calculate(expression) == 0) {
                    results.add(expression)
                }
                return
            }

            for (operator in listOf(' ', '+', '-')) {
                operators[depth] = operator
                backtracking(depth + 1)
            }
        }

        backtracking(0)
        results.sorted().forEach { println(it) }
        println()
    }
}

fun calculate(expression: String): Int {
    val parsedExpression = expression.replace(" ", "")
    var sum = 0
    var current = 0
    var sign = 1

    parsedExpression.forEach {
        when (it) {
            '+' -> {
                sum += sign * current
                sign = 1
                current = 0
            }

            '-' -> {
                sum += sign * current
                sign = -1
                current = 0
            }

            else -> {
                current = current * 10 + (it - '0')
            }
        }
    }

    sum += sign * current

    return sum
}
