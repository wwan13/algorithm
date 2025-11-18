package boj1068

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val parents = readLine().split(" ").map { it.toInt() }
    val remove = readLine().toInt()

    val root = parents.indexOf(-1)
    if (remove == root) {
        println(0)
        return@with
    }

    val tree = Array(n) { mutableListOf<Int>() }
    for (i in 0 until n) {
        val parent = parents[i]

        if (parent == -1) continue

        // 삭제 될 노드, 그 자식 노드는 트리에 삽입하지 않음
        if (i == remove || parent == remove) continue

        tree[parent].add(i)
    }

    var leafCount = 0

    val stack = ArrayDeque<Int>()
    stack.add(root)

    while (stack.isNotEmpty()) {
        val node = stack.removeLast()

        if (node == remove) continue

        // 자식이 없는 경우 : 리프
        if (tree[node].isEmpty()) {
            leafCount++
            continue
        }

        for (child in tree[node]) {
            stack.add(child)
        }
    }

    println(leafCount)
}