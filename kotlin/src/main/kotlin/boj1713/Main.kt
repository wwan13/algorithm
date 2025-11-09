package boj1713

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val total = readLine().toInt()
    val recommended = readLine().split(" ").map { it.toInt() }

    val frames = mutableMapOf<Int, Pair<Int, Int>>()

    for (t in 0 until total) {
        val student = recommended[t]

        when {
            // 이미 프레임에 올라가 있을 때
            frames.containsKey(student) -> {
                val (vote, time) = frames[student]!!
                frames[student] = vote + 1 to time
            }

            // 비어있는 자리가 있을 때
            frames.size < n -> {
                frames[student] = 1 to t
            }

            // 비어있는 자리가 없을 때
            else -> {
                val removeComparing = compareBy<Map.Entry<Int, Pair<Int, Int>>> { it.value.first }
                    .thenBy { it.value.second }
                val removeTarget = frames.minWith(removeComparing).key
                frames.remove(removeTarget)
                frames[student] = 1 to t
            }
        }
    }

    frames.keys.sorted().forEach { print("$it ") }
}