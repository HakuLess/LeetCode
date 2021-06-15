package leetcode.contest.cur.leetcode.c245

import leetcode.contest.utils.isSubSeqOf
import leetcode.contest.utils.print
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val s = Solution5786()
    s.maximumRemovals("abcacb", "ab", intArrayOf(3, 1, 0)).print()
//    s.maximumRemovals("abcacb", "ab", intArrayOf(3, 2, 1, 4, 5, 6)).print()
}

class Solution5786 {
    fun maximumRemovals(s: String, p: String, removable: IntArray): Int {
        fun check(k: Int): Boolean {
            // 教训：String操作要用StringBuilder
            val str = StringBuilder(s)
            removable.take(k).forEach {
                str.setCharAt(it, ' ')
            }
            return p.isSubSeqOf(str.toString())
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