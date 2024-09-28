package 백준._3_골드.분할정복.P1074

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (N, r, c) = br.readLine().split(" ").map { it.toInt() }
    println(findOrder(N, r, c))
}

fun findOrder(N: Int, r: Int, c: Int): Int {
    var order = 0
    var size = 1 shl N // 2^N
    var currentR = 0
    var currentC = 0

    while (size > 1) {
        size /= 2

        // 4개의 사분면 확인
        val quadrant = when {
            r < currentR + size && c < currentC + size -> 0 // 좌상단
            r < currentR + size && c >= currentC + size -> 1 // 우상단
            r >= currentR + size && c < currentC + size -> 2 // 좌하단
            else -> 3 // 우하단
        }

        // 현재 사분면 이전의 모든 칸 수를 더함
        order += size * size * quadrant
        println("size * size * quadrant: ${(size * size * quadrant).toString().padEnd(7)} || size: ${size.toString().padEnd(4)} quadrant: $quadrant")

        // 현재 위치 업데이트
        when (quadrant) {
            1 -> currentC += size
            2 -> currentR += size
            3 -> {
                currentC += size
                currentR += size
            }
        }
    }
    return order
}
