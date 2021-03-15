package leetcode.contest.last.b43

class Solution1716 {
    fun totalMoney(n: Int): Int {
        val w = n / 7
        val d = n % 7
        var ans = (28 + (w - 1) * 7 + 28) * w / 2
        ans += (w + 1 + w + 1 + d - 1) * d / 2
        return ans
    }
}