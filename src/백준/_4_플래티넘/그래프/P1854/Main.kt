package 백준._4_플래티넘.그래프.P1854

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k) = bf.readLine().split(" ").map { it.toInt() }

    val nodes = List(n + 1) { mutableListOf<Node>() }

    repeat(m) {
        val (a, b, c) = bf.readLine().split(" ").map { it.toInt() }
        nodes[a].add(Node(b, c))
    }

    val values = List(n + 1) { PriorityQueue<Int>(compareByDescending { it }) }

    val queue = PriorityQueue<Node>()
    queue.offer(Node(1, 0))
    values[1].add(0)

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        nodes[current.end].forEach { node ->
            val next = node.end
            val newValue = current.value + node.value
            if (values[next].size < k) {
                values[next].add(newValue)
                queue.offer(Node(next, newValue))
            } else if (values[next].peek() > newValue) {
                values[next].poll()
                values[next].add(newValue)
                queue.offer(Node(next, newValue))
            }
        }
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for (i in 1..n) {
        if (values[i].size == k) {
            bw.write("${values[i].peek()}\n")
        } else {
            bw.write("-1\n")
        }
    }
    bw.flush()
    bw.close()
}

data class Node(val end: Int, val value: Int) : Comparable<Node> {
    override fun compareTo(other: Node) = value.compareTo(other.value)
}
