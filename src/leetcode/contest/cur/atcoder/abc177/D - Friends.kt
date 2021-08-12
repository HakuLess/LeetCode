package leetcode.contest.cur.atcoder.abc177

import leetcode.contest.utils.UFS

// rubbish
fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val parent = IntArray(n) { it }

    fun find(x: Int): Int {
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    repeat(m) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() - 1 }
        val px = find(a)
        val py = find(b)
        if (px < py) {
            parent[py] = px
        } else {
            parent[px] = py
        }
    }
    val ans = HashMap<Int, Int>()
    for (i in 0 until n) {
        val key = find(i)
        ans[key] = ans.getOrDefault(key, 0) + 1
    }
    println(ans.map { it.value }.maxOrNull())
}