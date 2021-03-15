package leetcode.contest.last.b44

class Solution1734 {
    fun decode(encoded: IntArray): IntArray {
        val n = encoded.size + 1
        val ans = IntArray(n)
        ans[0] = 1
        for (i in 2..n) {
            ans[0] = ans[0] xor i
        }
        for (i in 1 until encoded.size step 2) {
            ans[0] = ans[0] xor encoded[i]
        }
        for (i in encoded.indices) {
            ans[i + 1] = encoded[i] xor ans[i]
        }
        return ans
    }
}