package leetcode.contest.cur.leetcode.b52

class Solution5743 {
    fun memLeak(memory1: Int, memory2: Int): IntArray {
        var m1 = memory1
        var m2 = memory2
        var cur = 1
        while (m1 >= cur || m2 >= cur) {
            if (m1 >= m2) {
                m1 -= cur
            } else {
                m2 -= cur
            }
            cur++
        }
        return intArrayOf(cur, m1, m2)
    }
}