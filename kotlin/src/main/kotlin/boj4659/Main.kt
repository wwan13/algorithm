package boj4659

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val password = readLine()
        if (password == "end") break

        val vowels = setOf('a', 'e', 'i', 'o', 'u')

        if (password.none { it in vowels }) {
            println("<$password> is not acceptable.")
            continue
        }

        var vowelCount = 0
        var consonantCount = 0
        var prev = password[0]
        var isAcceptable = true

        if (prev in vowels) vowelCount++ else consonantCount++

        for (i in 1 until password.length) {
            val target = password[i]

            if (prev == target && target != 'e' && target != 'o') {
                isAcceptable = false
                break
            }

            if (target in vowels) {
                vowelCount++
                consonantCount = 0
            } else {
                consonantCount++
                vowelCount = 0
            }

            if (vowelCount == 3 || consonantCount == 3) {
                isAcceptable = false
                break
            }

            prev = target
        }

        if (isAcceptable) {
            println("<$password> is acceptable.")
        } else {
            println("<$password> is not acceptable.")
        }
    }
}
