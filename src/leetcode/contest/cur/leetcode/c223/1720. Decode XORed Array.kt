package leetcode.contest.cur.leetcode.c223

class Solution1720 {
    fun decode(encoded: IntArray, first: Int): IntArray {
        val n = encoded.size
        val ans = IntArray(n + 1)
        ans[0] = first
        for (i in 1 until ans.size) {
            ans[i] = ans[i - 1] xor encoded[i - 1]
        }
        return ans
    }
}