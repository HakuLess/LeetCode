package leetcode.contest.cur.leetcode.b44

class Solution1732 {
    fun largestAltitude(gain: IntArray): Int {
        var cur = 0
        var ans = 0
        gain.forEach {
            cur += it
            ans = maxOf(ans, cur)
        }
        return ans
    }
}