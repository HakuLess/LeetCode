package leetcode.contest.cur.atcoder.abc187

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val l = ArrayList<Pair<Int, Int>>()
    repeat(n) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        l.add(Pair(a, b))
    }
    var ans = 0
    for (i in l.indices) {
        for (j in i + 1 until l.size) {
            val a = l[i]
            val b = l[j]
            if (a.first != b.first) {
                val cur = (b.second - a.second).toDouble() / (b.first - a.first)
                if (cur >= -1.0 && cur <= 1.0) {
                    ans++
                }
            }
        }
    }
    println(ans)
}