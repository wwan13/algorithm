package boj21939

import java.util.TreeMap
import java.util.TreeSet

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val levels = TreeMap<Int, TreeSet<Int>>()
    val levelOf = HashMap<Int, Int>()

    fun addProblem(p: Int, l: Int) {
        levelOf[p]?.let { old ->
            levels[old]?.remove(p)
            if (levels[old]?.isEmpty() == true) levels.remove(old)
        }
        val set = levels[l] ?: TreeSet<Int>().also { levels[l] = it }
        set.add(p)
        levelOf[p] = l
    }

    repeat(n) {
        val (ps, ls) = readLine().split(" ")
        addProblem(ps.toInt(), ls.toInt())
    }

    val m = readLine().toInt()
    repeat(m) {
        val token = readLine().split(" ")
        when (token[0]) {
            "add" -> {
                val p = token[1].toInt()
                val l = token[2].toInt()
                addProblem(p, l)
            }

            "recommend" -> {
                val x = token[1].toInt()
                if (x == 1) {
                    val e = levels.lastEntry()
                    val ans = e.value.last()
                    println(ans)
                } else if (x == -1) {
                    val e = levels.firstEntry()
                    val ans = e.value.first()
                    println(ans)
                }
            }

            "solved" -> {
                val p = token[1].toInt()
                levelOf[p]?.let { l ->
                    levels[l]?.remove(p)
                    if (levels[l]?.isEmpty() == true) levels.remove(l)
                    levelOf.remove(p)
                }
            }
        }
    }
}