package 프로그래머스.lv2.미로탈출

import java.util.*

class Solution {
    val a = arrayOf(0, 0, 1, -1)
    val b = arrayOf(1, -1, 0, 0)
    private var leverPair = Pair(0, 0)
    private var exitPair = Pair(0, 0)
    private var startPair = Pair(0, 0)
    fun solution(maps: Array<String>): Int {
        repeat(maps.size) { x ->
            repeat(maps[0].length) { y ->
                when {
                    maps[x][y] == 'S' -> {
                        startPair = Pair(x, y)
                    }
                    maps[x][y] == 'L' -> {
                        leverPair = Pair(x, y)
                    }
                    maps[x][y] == 'E' -> {
                        exitPair = Pair(x, y)
                    }
                }
            }
        }
        fun bfs(start: Pair<Int, Int>, end: Pair<Int, Int>, map :Array<String>): Int {
            val visited = Array(map.size) {IntArray(map[0].length) {-1}}
            visited[start.first][start.second] = 0
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.add(start.first to start.second)
            while (queue.isNotEmpty()) {
                val (dX, dY) = queue.poll()
                if (dX == end.first && dY == end.second) {
                    return visited[dX][dY]
                }
                for (i in 0..3) {
                    val pointX = dX + a[i]
                    val pointY = dY + b[i]
                    if (pointX in maps.indices &&
                        pointY in maps[0].indices &&
                        visited[pointX][pointY] == -1 &&
                        maps[pointX][pointY] != 'X'
                    ) {
                        visited[pointX][pointY] = visited[dX][dY] + 1
                        queue.add(pointX to pointY)
                    }
                }
            }

            return -1
        }

        val lever = bfs(startPair, leverPair, maps)
        val exit = bfs(leverPair, exitPair, maps)
        return if (lever != -1 && exit != -1) {
            lever + exit
        } else {
            -1
        }
    }
}
