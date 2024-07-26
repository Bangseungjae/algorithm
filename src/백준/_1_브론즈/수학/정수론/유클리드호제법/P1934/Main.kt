package 백준._1_브론즈.수학.정수론.유클리드호제법.P1934

fun main()  = with(System.`in`.bufferedReader()){
    val list: MutableList<Pair<Int, Int>> = mutableListOf()
    val bw = System.out.bufferedWriter()
    val T = readLine().toInt()
    (1..T).forEach {
        val n = readLine().split(' ').map { it.toInt() }
        if (n[0] > n[1]) list.add(n[0] to n[1]) else list.add(n[1] to n[0])
    }

    for (pair in list) {
        val x = pair.first * pair.second / gcd(pair.first, pair.second)
        bw.write("$x\n")
    }
    bw.flush()
    bw.close()
}

fun gcd(num1: Int, num2: Int): Int {
    var x = num1
    var y = num2
    while ( y != 0) {
        val j = x % y
        x = y
        y = j
    }
    return x
}
