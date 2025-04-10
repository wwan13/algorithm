package boj2607

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val words = Array(n) { readLine() }
    val base = words[0]

    fun getCharCount(word: String): IntArray {
        val count = IntArray(26)
        for (ch in word) {
            count[ch - 'A']++
        }
        return count
    }

    val baseCount = getCharCount(base)
    var result = 0

    for (i in 1 until n) {
        val targetCount = getCharCount(words[i])
        var plus = 0
        var minus = 0

        for (j in 0 until 26) {
            val d = baseCount[j] - targetCount[j]
            if (d > 0) minus += d
            else plus -= d
        }

        if ((plus == 1 && minus == 0) ||
            (plus == 0 && minus == 1) ||
            (plus == 1 && minus == 1) ||
            (plus == 0 && minus == 0)
        ) {
            result++
        }
    }

    println(result)
}
