package 백준._3_골드.그래프.벨만포드.P11657

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val edges = mutableListOf<Edge>()
    val distance = LongArray(n + 1) { Long.MAX_VALUE }
    distance[1] = 0L

    repeat(m) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        edges.add(Edge(a, b, c))
    }

    for (i in 1..n) {
        for (j in 0 until m) {
            val edge = edges[j]
            if (distance[edge.start] != Long.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.weight) {
                distance[edge.end] = distance[edge.start] + edge.weight
                if (i == n) {
                    println(-1)
                    return
                }
            }
        }
    }

    for (i in 2..n) {
        if (distance[i] == Long.MAX_VALUE) {
            println(-1)
        } else {
            println(distance[i])
        }
    }
}

data class Edge(val start: Int, val end: Int, val weight: Int)
