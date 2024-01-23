package 프로그래머스.베스트앨범

fun main(args: Array<String>) {
    val genres = arrayOf(
        "classic", "pop", "classic", "classic", "pop", "classic", "classic"
    )
    val plays = intArrayOf(
        500, 600, 150, 800, 2500, 800, 900
    )

    println(Solution().solution(genres, plays).toList())
}

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val answer = intArrayOf()
        val songs: MutableList<Song> = mutableListOf()

        genres.indices.forEach { index ->
            songs.find { x -> x.name == genres[index] }
                ?.let {
                    val ints = it.play[plays[index]]
                        ?.let { x -> x.add(index) }
                        ?: run { it.play[plays[index]] = mutableListOf(index) }

                }
                ?: run {
                    songs.add(Song(genres[index], hashMapOf(plays[index] to mutableListOf(index))))
                }
        }
        val sortedByDescending = songs.sortedByDescending { it.play.map { (key, value) -> key }.toList().sum() }

        val answerList = answer.toMutableList()

        val map = sortedByDescending.map { it ->
            val sortedWith = it.play.toList()
                .sortedWith(
                    compareByDescending<Pair<Int, MutableList<Int>>> { it.first }
                )
            sortedWith
        }
        var count = 0
        map.forEach { song ->
                song.forEach { play ->
                    play.second.forEach { index ->
                        if (count < 2) {
                            count++
                            answerList.add(index)
                        }
                    }
                }
            count = 0
        }
        return answerList.toIntArray()
    }

    data class Song(
        val name: String,
        val play: HashMap<Int, MutableList<Int>>,
    )
}
