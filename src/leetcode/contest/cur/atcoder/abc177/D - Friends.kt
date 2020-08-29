package leetcode.contest.cur.atcoder.abc177

import leetcode.contest.utils.UFS

// todo check
fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val ufs = UFS(n)
    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() - 1 }
        ufs.union(a, b)
    }
    val ans = HashMap<Int, Int>()
    for (i in 0 until n) {
        val key = ufs.find(i)
        ans[key] = ans.getOrDefault(key, 0) + 1
    }
    println(ans.map { it.value }.max())
}