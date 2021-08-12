package leetcode.contest.last.b02

class Solution1085 {
    fun sumOfDigits(A: IntArray): Int {
        var min = A.minOrNull()!!
        var ans = 0
        while (min > 0) {
            ans += min % 10
            min /= 10
        }
        return if (ans % 2 == 0) {
            1
        } else {
            0
        }
    }
}