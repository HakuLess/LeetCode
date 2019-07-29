package leetcode.contest.c147

class Solution1137 {
    fun tribonacci(n: Int): Int {
        val ans = IntArray(38)
        ans[0] = 0
        ans[1] = 1
        ans[2] = 1
        for (i in 3..37) {
            ans[i] = ans[i - 1] + ans[i - 2] + ans[i - 3]
        }
        return ans[n]
    }
}