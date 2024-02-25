package 백준._3_골드.위상정렬.P1516

import java.util.LinkedList

fun main() {
    val n = readln().toInt()
    val time = IntArray(n + 1)
    val result = IntArray(n + 1)
    val inDegree = IntArray(n + 1)
    val graph = Array(n + 1) { mutableListOf<Int>() }

    (1..n).forEach { i ->
        val split = readln().split(" ").map { it.toInt() }
        time[i] = split[0]
        for (j in 1 until split.size - 1) {
            graph[split[j]].add(i)
            inDegree[i]++
        }
    }

    val queue = LinkedList<Int>()

    for (i in 1 .. n) {
        if (inDegree[i] == 0) {
            queue.offer(i)
            result[i] = time[i]
        }
    }

    while (queue.isNotEmpty()) {
        val now = queue.remove()
        for (i in graph[now]) {
            inDegree[i]--
            result[i] = maxOf(result[i], time[i] + result[now])
            if (inDegree[i] == 0) {
                queue.offer(i)
            }
        }
    }

    for (i in 1..n) {
        println(result[i])
    }
}
