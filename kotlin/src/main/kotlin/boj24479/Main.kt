package boj24479

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, r) = readLine().split(" ").map { it.toInt() }

    val tree = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        tree[a].add(b)
        tree[b].add(a)
    }
    tree.forEach { it.sort() }

    val visited = IntArray(n + 1) { 0 }
    var order = 1

    fun dfs(current: Int) {
        visited[current] = order++
        for (next in tree[current]) {
            if (visited[next] == 0) {
                dfs(next)
            }
        }
    }

    dfs(r)

    println(visited.drop(1).joinToString("\n"))
}
