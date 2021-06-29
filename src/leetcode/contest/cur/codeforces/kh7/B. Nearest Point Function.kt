package leetcode.contest.cur.codeforces.kh7

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val n = readLine()!!.toInt()
        val arr = readLine()!!.split(" ").map { it.toInt() }
        var ans = "NO"
        for (j in 1 until arr.size) {
            if ((arr[j] + arr[j - 1]) % 2 == 0) {
                ans = "YES"
                break
            }
        }
        println(ans)
    }
}