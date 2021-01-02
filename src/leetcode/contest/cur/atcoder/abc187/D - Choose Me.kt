package leetcode.contest.cur.atcoder.abc187

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val l = ArrayList<Pair<Long, Long>>()
    repeat(n) {
        val (a, b) = readLine()!!.split(' ').map { it.toLong() }
        l.add(Pair(a, b))
    }
    l.sortByDescending { it.first * 2 + it.second }
    var a = l.map { it.first }.sum()
    var b = 0L
    var index = 0
    while (a >= b) {
        a -= l[index].first
        b += l[index].second + l[index].first
        index++
    }
    println(index)
}