package leetcode.contest.cur.leetcode.b39

class Solution1652 {
    fun decrypt(code: IntArray, k: Int): IntArray {
        val ans = IntArray(code.size)
        if (k == 0) return ans
        if (k > 0) {
            for (i in ans.indices) {
                var cur = 0
                for (j in 1..k) {
                    cur += code[(i + j) % ans.size]
                }
                ans[i] = cur
            }
        } else {
            for (i in ans.indices) {
                var cur = 0
                for (j in -1 downTo k) {
                    cur += code[(i + j + ans.size) % ans.size]
                }
                ans[i] = cur
            }
        }
        return ans
    }
}