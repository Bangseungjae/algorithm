package 백준._1_브론즈.수학.조합.P2775

fun main() {
    val array = Array(15) { IntArray(15) }
    for (i: Int in 0..14) {
        array[i][1] = 1
        array[0][i] = i
    }
    for (i in 1..14) {
        for (j in 2..14) {
            array[i][j] = array[i][j - 1] + array[i - 1][j]
        }
    }

    val N = readln().toInt()

    repeat(N) {
        val n = readln().toInt()
        val k = readln().toInt()
        println(array[n][k])
    }
}
