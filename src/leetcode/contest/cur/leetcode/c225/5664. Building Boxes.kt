package leetcode.contest.cur.leetcode.c225

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5664()
    s.minimumBoxes(3).print()
    s.minimumBoxes(4).print()
    s.minimumBoxes(10).print()
    s.minimumBoxes(11).print()
    s.minimumBoxes(15).print()
    s.minimumBoxes(21).print()
}

class Solution5664 {
    fun minimumBoxes(n: Int): Int {
        if (n == 0) return 0
        var sum = 0
        val arr = arrayListOf<Int>()
        var cur = 1
        while (sum + (arr.lastOrNull() ?: 0) + cur < n) {
            arr.add(cur + (arr.lastOrNull() ?: 0))
            sum += arr.last()
            cur++
        }
        fun dfs(n: Int): Int {
            var cur = 1
            var sum = 0
            while (sum < n) {
                sum += cur
                cur++
            }
            return cur - 1
        }
        return (arr.lastOrNull() ?: 0) + if (sum < n) dfs(n - sum) else 0
    }
}