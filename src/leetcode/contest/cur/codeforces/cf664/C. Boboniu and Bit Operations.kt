package leetcode.contest.cur.codeforces.cf664

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = readLine()!!
    val a = readLine()!!.split(' ').map { it.toInt() }.sortedDescending()
    val b = readLine()!!.split(' ').map { it.toInt() }.sorted()

    var pre = 0
    for (i in a) {
        var cur = Int.MAX_VALUE
        for (j in b) {
            cur = minOf(cur, pre or (i and j))
//            println("$i $j : $cur")
        }
        pre = cur
    }
    println(pre)
}