package leetcode.contest.cur.atcoder.abc187

import leetcode.contest.utils.UFS

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val cur = LongArray(n)
    val l = ArrayList<Pair<Int, Int>>()
    repeat(n - 1) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        l.add(Pair(a, b))
    }
    val m = readLine()!!.toInt()
    repeat(m) {
        var (t, e, x) = readLine()!!.split(' ').map { it.toInt() }
        e--
        val reach = if (t == 1) l[e].first else l[e].second
        val without = if (t == 1) l[e].second else l[e].first
        val ufs = UFS(n)
        for (i in l.indices) {
            if (l[i].first == without || l[i].second == without) continue
            ufs.union(l[i].first - 1, l[i].second - 1)
        }
        for (i in cur.indices) {
            if (ufs.find(i) == ufs.find(reach - 1)) {
                cur[i] += x.toLong()
            }
        }
    }
    cur.forEach {
        println(it)
    }
}