package 백준._3_골드.유니온파인드.P1976

lateinit var parent: IntArray

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt() // 사용 x

    parent = IntArray(n + 1) { it }
    (1..n).forEach { i ->
        val input = readLine().split(" ").map { it.toInt() }
        (0 until n).forEach { j ->
            if (input[j] == 1) {
                union(i, j + 1)
            }
        }
    }
    val plan = readLine().split(" ").map { it.toInt() }
    val result = plan.map { find(it) }.toSet()
    if (result.size == 1) {
        println("YES")
    } else {
        println("NO")
    }
}

fun union(i: Int, j: Int) {
    val a = find(i)
    val b = find(j)
    if (a != b) {
        parent[b] = a
    }
}

fun find(a: Int): Int {
    if (parent[a] == a) {
        return parent[a]
    }
    return find(parent[a]).also { parent[a] = it }
}
