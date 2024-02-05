package 백준._3_골드.정수론.P1456

import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val split = readLine()!!.split(' ').map { it.toLong() }
    val min = split[0]
    val max = split[1]

    val arr = LongArray(10_000_001)

    (2 until arr.size).forEach { arr[it] = it.toLong() }

    for (i: Int in 2 .. sqrt(arr.size.toDouble()).toInt()) {
        if (arr[i] == 0L) {
            continue
        }
        for (j: Int in i + i until arr.size step i) {
            arr[j] = 0L
        }
    }

    var count = 0
    for (i: Int in 2 until 10_000_001) {
        if (arr[i] != 0L) {
            var temp = arr[i]
            while (arr[i].toDouble() <= max.toDouble() / temp.toDouble()) {
                if (arr[i].toDouble() >= min.toDouble() / temp.toDouble()) {
                    count++
                }
                temp *= arr[i]
            }
        }
    }
    println(count)
}
