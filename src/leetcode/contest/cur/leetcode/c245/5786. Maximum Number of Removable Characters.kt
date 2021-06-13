package leetcode.contest.cur.leetcode.c245

import leetcode.contest.utils.isSubSeqOf
import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5786()
    s.maximumRemovals("abcacb", "ab", intArrayOf(3, 1, 0)).print()
//    s.maximumRemovals("abcacb", "ab", intArrayOf(3, 2, 1, 4, 5, 6)).print()
}

class Solution5786 {
    fun maximumRemovals(s: String, p: String, removable: IntArray): Int {
        fun check(k: Int): Boolean {
            val mark = BooleanArray(s.length)
            for (i in 0 until k) {
                mark[removable[i]] = true
            }
            return p.isSubSeqOf(s, mark)
        }

        var left = 0
        var right = removable.size
        while (left + 1 < right) {
            val mid = (left + right).ushr(1)

            when {
                check(mid) -> left = mid
                else -> right = mid
            }
        }
        return if (check(right)) {
            right
        } else {
            left
        }
    }
}