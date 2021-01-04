package leetcode.contest.cur.codeforces.cf693

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        var (w, h, n) = readLine()!!.split(" ").map { it.toInt() }
        var a = 1
        var b = 1
        while (w % 2 == 0) {
            w /= 2
            a *= 2
        }
        while (h % 2 == 0) {
            h /= 2
            b *= 2
        }
        if (a * b >= n) {
            println("YES")
        } else {
            println("NO")
        }
    }
}