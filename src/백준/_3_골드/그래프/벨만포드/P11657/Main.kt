package 백준._3_골드.그래프.벨만포드.P11657

import 백준._4_플래티넘.그래프.P1854.Node

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val nodes = List(n + 1) { mutableListOf<Node>() }

    repeat(m) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        nodes[a].add(Node(b, c))
    }

    val distances = LongArray(n + 1) { Long.MAX_VALUE }
    distances[1] = 0

    for (i in 1..n) {
        for (j in 1..n) {
            nodes[j].forEach { node ->
                if (distances[j] != Long.MAX_VALUE && distances[node.end] > distances[j] + node.value) {
                    distances[node.end] = distances[j] + node.value
                    if (i == n) {
                        println(-1)
                        return
                    }
                }
            }
        }
    }

    for (i in 2..n) {
        if (distances[i] == Long.MAX_VALUE) {
            println(-1)
        } else {
            println(distances[i])
        }
    }
}
