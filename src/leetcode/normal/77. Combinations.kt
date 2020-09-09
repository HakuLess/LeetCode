package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution77()
    s.combine(4, 2).print()
}

class Solution77 {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()
        fun checkCur(t: Int, cur: ArrayList<Int>) {
            if (cur.size == k) {
                result.add(ArrayList(cur))
                return
            }
            for (i in t..n) {
                cur.add(i)
                checkCur(i + 1, cur)
                cur.remove(i)
            }
        }
        checkCur(1, arrayListOf())
        return result
    }
}