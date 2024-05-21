package 프로그래머스.lv2.두큐합같게만들기

import java.util.*
class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val queueA = LinkedList(queue1.toList().map { it.toLong() })
        val queueB = LinkedList(queue2.toList().map { it.toLong() })
        var cnt = 0
        var sumA = queueA.sumOf { it }
        var sumB = queueB.sumOf { it }

        while ((queueA.size + queueB.size) * 6 >= cnt) {
            if (sumA == sumB) {
                return cnt
            }

            if (sumA < sumB && queueB.isNotEmpty()) {
                val poll = queueB.poll()
                sumB -= poll
                sumA += poll
                queueA.offer(poll)
            } else {
                val poll = queueA.poll()
                sumB += poll
                sumA -= poll
                queueB.offer(poll)
            }
            cnt++
        }

        val answer: Int = -1
        return answer
    }
}

fun main() {
    val queue1 = intArrayOf(3, 2, 7, 2)
    val queue2 = intArrayOf(4, 6, 5, 1)

    val solution = Solution().solution(queue1, queue2)
    println(solution)
}
