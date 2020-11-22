package leetcode.contest.cur.atcoder.abc184

import java.util.*

fun main(args: Array<String>) {
    val (t, n) = readLine()!!.split(' ').map { it.toLong() }
    val arr = readLine()!!.split(' ').map { it.toLong() }
    val set = TreeSet<Long>()
    for (i in arr.indices) {
        val t = hashSetOf<Long>()
        set.forEach {
            if (it + arr[i] <= n) {
                t.add(it + arr[i])
            }
        }
        set.addAll(t)
        if (arr[i] <= n) {
            set.add(arr[i])
        }
    }
    println(set.lower((n + 1)) ?: 0)
}