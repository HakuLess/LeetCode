package leetcode.normal

class Solution258 {
    fun addDigits(num: Int): Int {
        var ans = 0
        num.toString().forEach {
            ans += it - '0'
            while (ans >= 10) {
                ans -= 9
            }
        }
        return ans
    }
}