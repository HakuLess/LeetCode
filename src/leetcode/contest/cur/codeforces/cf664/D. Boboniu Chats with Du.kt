package leetcode.contest.cur.codeforces.cf664

import java.util.*

fun main(args: Array<String>) {
    val (n, d, m) = readLine()!!.split(' ').map { it.toInt() }
    val l = readLine()!!.split(' ').map { it.toInt() }

    val l0 = arrayListOf<Long>()
    val l1 = arrayListOf<Long>()
    l.forEach {
        if (it > m) l0.add(it.toLong())
        else l1.add(it.toLong())
    }

    l0.sort()
    l1.sort()
    if (l0.isEmpty()) {
        println(l1.sum())
        return
    }
    var ans = l0.last()
    l0.remove(l0.last())

    var i = 0
    var j = 0
    while (i in l0.indices && j in l1.indices) {
        var cur = 0L
        for (t in 0 until d) {
            if (j + t in l1.indices)
                cur += l1[j + t]
        }
        while (l0[i] < cur && (i + 1) in l0.indices) {
            i++
        }
        ans += maxOf(cur, l0[i])
//        println("ans $ans")
        j += d
        i++
    }
    for (i in j..l1.lastIndex) {
        ans += l1[i]
//        println("after $ans")
    }
    println(ans)
}