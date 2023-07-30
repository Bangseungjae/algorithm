package 프로그래머스.문자열.문자열압축

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */
class Solution {
    fun solution(s: String): Int {

        var min = Int.MAX_VALUE
        for (length in 1 .. s.length) {
            val compress = compress(s, length)
            if (compress < min) min = compress
        }
        return min
    }
}

private fun compress(source: String, length: Int): Int {
    // 압축된 문자열의 길이 반환
    val builder = StringBuilder()

    var last = ""
    var count = 0
    for (token: String in split(source, length)) {
        if (token == last) {
            count++
        } else {
            if (count > 1) builder.append(count)
            builder.append(last)
            last = token
            count = 1
        }
    }
    if (count > 1) builder.append(count)
    builder.append(last)
    return builder.length

}

private fun split(source: String, length: Int): MutableList<String> {
    val tokens = mutableListOf<String>()
    // source를 length만큼식 잘라 tokens 리스트에 추가
    for (startIndex in source.indices step length) {
        var endIndex: Int = startIndex + length
        if (endIndex > source.length) endIndex = source.length
        tokens.add(source.substring(startIndex, endIndex))
    }
    return tokens
}

    fun main(args: Array<String>) {
        println(Int.MAX_VALUE)
        val solution = Solution().solution("aabbaccc")
        println(solution)
    }
