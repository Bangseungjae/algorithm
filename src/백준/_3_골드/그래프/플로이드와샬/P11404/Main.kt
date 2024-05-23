package 백준._3_골드.그래프.플로이드와샬.P11404


fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val arr = Array(n + 1) { LongArray(n + 1) { Long.MAX_VALUE } }
    for (i in 1..n) {
        arr[i][i] = 0L
    }
    repeat(m) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (arr[a][b] > c) {
            arr[a][b] = c.toLong()
        }
    }

    for (k in 1..n) {
        for (s in 1..n) {
            for (e in 1..n) {
                if (arr[s][k] != Long.MAX_VALUE && arr[k][e] != Long.MAX_VALUE && s != e) {
                    arr[s][e] = Math.min(arr[s][e], arr[s][k] + arr[k][e])
                }

            }
        }
    }

    val sb = StringBuilder()

    for (i in 1..n) {
        for (j in 1..n) {
            if (arr[i][j] == Long.MAX_VALUE) {
                sb.append("0 ")
            } else {
                sb.append("${arr[i][j]} ")
            }
        }
        sb.append("\n")
    }
    println(sb)
}
