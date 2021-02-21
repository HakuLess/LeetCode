package leetcode.contest.cur.leetcode.b46

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5669()
    s.canChoose("[[1,-1,-1],[3,-2,0]]".toGrid(), intArrayOf(1, -1, 0, 1, -1, -1, 3, -2, 0)).print()
}

class Solution5669 {
    fun canChoose(groups: Array<IntArray>, nums: IntArray): Boolean {
        var i = 0
        for (group in groups) {
            val n = group.size
            var res = i
            for (j in i until nums.size) {
                if (j + n - 1 in nums.indices && nums.slice(IntRange(j, j + n - 1)).toIntArray().contentEquals(group)) {
                    res = j + n
                    break
                }
            }
            if (res > i)
                i = res
            else
                return false
        }
        return true
    }
}