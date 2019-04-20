package leetcode.normal

class Solution357 {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        return when (n) {
            0 -> 0
            1 -> 10
            2 -> 9 * 9 + countNumbersWithUniqueDigits(2 - 1)
            else -> {
                var ans = 9
                for (i in 0 until n - 1) {
                    ans *= (9 - i)
                }
                ans + countNumbersWithUniqueDigits(n - 1)
            }
        }
    }
}