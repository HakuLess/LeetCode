package leetcode.contest.cur.cf652

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    for (i in 0 until t) {
        val (a, b) = readLine()!!.split(" ")
        val array = readLine()!!.split(" ").map { it.toInt() }
        val t = readLine()!!.split(" ").map { it.toInt() }
        val list = array.sortedDescending()
        var ans = 0L
        val c = t.count { it == 1 }
        for (i in 0 until c) {
            ans += 2 * list[i]
        }
//        ans.print()
        for (i in c until b.toInt()) {
//            println("add $c..${b.toInt()}  ${list[i]}")
            ans += list[i]
        }
//        ans.print()
        val sorted = list.sorted()
        var index = 0
        for (i in 0 until b.toInt() - c) {
            ans += sorted[index]
//            println("add  ${sorted[index]}")
            index += b.toInt() - c
        }
        println(ans)
    }
}