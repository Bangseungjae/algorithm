package 백준._3_골드.분할정복.P1074

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val (N: Int, r: Int, c: Int) = BufferedReader(InputStreamReader(System.`in`))
        .readLine()
        .split(" ")
        .map { it.toInt() }
    println(solve(N, r, c))
}

/**
 * r < half && c < half -> solve(N - 1, r, c)
 *
 * 이는 왼쪽 상단 사분면에 해당합니다.
 * 이 경우, 현재 사분면 내에서 같은 패턴으로 재귀적으로 탐색을 계속합니다.
 * 추가적인 오프셋 계산이 필요 없습니다.
 *
 *
 * r < half && c >= half -> half * half + solve(N - 1, r, c - half)
 *
 * 이는 오른쪽 상단 사분면에 해당합니다.
 * half * half를 더하는 이유는 왼쪽 상단 사분면의 모든 칸을 지났기 때문입니다.
 * c - half는 현재 사분면 내에서의 상대적 위치를 계산하기 위함입니다.
 *
 *
 * r >= half && c < half -> 2 * half * half + solve(N - 1, r - half, c)
 *
 * 이는 왼쪽 하단 사분면에 해당합니다.
 * 2 * half * half를 더하는 이유는 상단의 두 사분면을 모두 지났기 때문입니다.
 * r - half는 현재 사분면 내에서의 상대적 위치를 계산하기 위함입니다.
 *
 *
 * else -> 3 * half * half + solve(N - 1, r - half, c - half)
 *
 * 이는 오른쪽 하단 사분면에 해당합니다.
 * 3 * half * half를 더하는 이유는 다른 세 사분면을 모두 지났기 때문입니다.
 * r - half와 c - half는 현재 사분면 내에서의 상대적 위치를 계산하기 위함입니다.
 */
fun solve(N: Int, r: Int, c: Int): Int {
    if (N == 0) return 0
    val half = 1 shl (N - 1)
    return when {
        r < half && c < half -> solve(N - 1, r, c)
        half in (r + 1)..c -> half * half + solve(N - 1, r, c - half)
        half in (c + 1)..r -> 2 * half * half + solve(N - 1, r - half, c)
        else -> 3 * half * half + solve(N - 1, r - half, c - half)
    }
}

/*
알고리즘: 분할정복, 재귀
 */
