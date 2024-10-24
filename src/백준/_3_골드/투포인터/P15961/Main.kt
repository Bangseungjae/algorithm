package 백준._3_골드.투포인터.P15961

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, d, k, c) = br.readLine().split(" ").map { it.toInt() }

    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = br.readLine().toInt()
    }

    val visited = IntArray(d + 1)
    var count = 0

    // 초기 윈도우 설정
    for (i in 0 until k) {
        if (visited[arr[i]] == 0) count++
        visited[arr[i]]++
    }

    var max = count
    // 쿠폰 초밥을 추가로 먹을 수 있는 경우 체크
    if (visited[c] == 0) {
        max++
    }

    var start = 0
    var end = k % n

    // 슬라이딩 윈도우 적용
    for (i in 1 until n) {
        // 이전 초밥 제거
        visited[arr[start]]--
        if (visited[arr[start]] == 0) {
            count--
        }
        start = (start + 1) % n

        // 새로운 초밥 추가
        if (visited[arr[end]] == 0) {
            count++
        }
        visited[arr[end]]++
        end = (end + 1) % n

        // 현재 종류 수 계산
        val total = if (visited[c] == 0) count + 1 else count

        if (total > max) {
            max = total
        }
    }

    println(max)
}
