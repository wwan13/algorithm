package boj2179

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val words = Array(n) { readLine()!! }

    val trie = Trie()
    words.forEachIndexed { index, word ->
        trie.insert(word, index)
    }

    val (first, second) = trie.find(words)
    println(first)
    println(second)
}

class Trie {
    class Node {
        val children = mutableMapOf<Char, Node>()
        val indices = mutableListOf<Int>()
    }

    private val root = Node()

    fun insert(word: String, index: Int) {
        var current = root
        for (char in word) {
            current = current.children.getOrPut(char) { Node() }
            if (current.indices.isEmpty() || current.indices.last() != index) {
                current.indices.add(index)
            }
        }
    }

    fun find(words: Array<String>): Pair<String, String> {
        var maxLength = -1
        var result = "" to ""

        fun dfs(node: Node, depth: Int) {
            if (node.indices.size < 2) return

            if (depth > maxLength) {
                maxLength = depth
                result = words[node.indices[0]] to words[node.indices[1]]
            }

            for (child in node.children.values) {
                dfs(child, depth + 1)
            }
        }

        for (child in root.children.values) {
            dfs(child, 1)
        }

        return if (maxLength == -1) words[0] to words[1] else result
    }
}
