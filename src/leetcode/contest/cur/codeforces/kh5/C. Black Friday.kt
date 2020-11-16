package leetcode.contest.cur.codeforces.kh5

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (n, k) = readLine()!!.split(" ").map { it.toInt() }
        val arr = readLine()!!.split(" ").map { it.toInt() }
        var ans = 0
        val cur = arrayListOf<Int>()
        arr.reversed().forEach {
            cur.add(it)
            if (cur.size % k == 0) {
                ans = maxOf(ans, cur.takeLast(cur.size / k).sum())
            }
        }
        println(ans)
    }
}