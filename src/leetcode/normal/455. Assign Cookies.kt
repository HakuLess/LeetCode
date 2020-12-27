package leetcode.normal

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val a = Solution455()
    a.findContentChildren(
            intArrayOf(1, 2, 3),
            intArrayOf(1, 1)
    ).print()

    a.findContentChildren(
            intArrayOf(1, 2),
            intArrayOf(1, 3)
    ).print()
}

class Solution455 {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sortDescending()
        s.sortDescending()
        var ans = 0
        var index = 0
        for (element in g) {
            if (index > s.lastIndex) {
                return ans
            }
            if (s[index] >= element) {
                index++
                ans++
            }
        }
        return ans
    }
}