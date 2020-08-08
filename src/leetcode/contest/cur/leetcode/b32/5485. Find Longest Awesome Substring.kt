package leetcode.contest.cur.leetcode.b32

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = Solution5485()
    s.longestAwesome("3242415").print()
//    s.longestAwesome("11").print()
//    s.longestAwesome("213123").print()
//    s.longestAwesome("234121442").print()
//    s.longestAwesome("76263").print()
//    s.longestAwesome("373781").print()
}

class Solution5485 {

    fun longestAwesome(s: String): Int {
        val leftMost = IntArray(1 shl 10) { Int.MAX_VALUE }
        leftMost[0] = -1
        var ans = 0
        var pre = 0
        for (i in s.indices) {
            val x = s[i] - '0'
            pre = pre xor (1 shl x)
            for (j in 0..9) {
                val target = 1 shl j
                ans = maxOf(ans, i - leftMost[pre xor target])
            }
            ans = maxOf(ans, i - leftMost[pre])
            leftMost[pre] = minOf(leftMost[pre], i)
        }
        return ans
    }
}