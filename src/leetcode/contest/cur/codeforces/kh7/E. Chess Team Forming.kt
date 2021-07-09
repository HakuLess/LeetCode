package leetcode.contest.cur.codeforces.kh7

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toLong() }.sorted()
    val b = readLine()!!.split(" ").map { it.toLong() }.sorted()
    val m = readLine()!!.toInt()
    val c = readLine()!!.split(" ").map { it.toLong() }

    val diff = ArrayList<Pair<Long, Long>>()
    for (i in 0 until n) {
        diff.add(Pair(b[i] - a[i], b[i + 1] - a[i]))
    }

    val pre = ArrayList<Long>()
    diff.forEach {
        pre.add(maxOf(pre.lastOrNull() ?: Long.MIN_VALUE / 2, it.first))
    }

    val suf = ArrayList<Long>()
    diff.reversed().forEach {
        suf.add(0, maxOf(suf.firstOrNull() ?: Long.MIN_VALUE / 2, it.second))
    }

    val result = ArrayList<Long>()
    for (t in c) {
        if (t <= a[0]) {
            result.add(maxOf(b[0] - t, suf[0]))
            continue
        } else if (t >= a.last()) {
            result.add(maxOf(b.last() - t, pre.last()))
            continue
        }

        var ans = Long.MIN_VALUE / 2
        var index = a.binarySearch(t)
        if (index < 0) index = -index - 1
        if (index - 1 in pre.indices)
            ans = maxOf(ans, pre[index - 1])
        if (index in suf.indices)
            ans = maxOf(ans, suf[index])
        ans = maxOf(ans, b[index] - t)
        result.add(ans)
    }
    println(result.joinToString(" "))
}