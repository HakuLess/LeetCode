package leetcode.contest.cur

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution77()
    s.combine(4, 2).print()
}

class Solution77 {
    val result = arrayListOf<List<Int>>()
    fun combine(n: Int, k: Int): List<List<Int>> {
        checkCur(n, k, 1, arrayListOf())
        return result
    }

    private fun checkCur(n: Int, k: Int, t: Int, cur: ArrayList<Int>) {
        if (cur.size == k) {
            result.add(ArrayList(cur))
            return
        }
        for (i in t..n) {
            cur.add(i)
            checkCur(n, k, i + 1, cur)
            cur.remove(i)
        }
    }
}