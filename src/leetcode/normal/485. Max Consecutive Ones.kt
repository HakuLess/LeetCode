package leetcode.normal

class Solution485 {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var ans = 0
        var cnt = 0
        nums.forEach {
            if (it == 1) cnt++
            else cnt = 0
            ans = maxOf(ans, cnt)
        }
        return ans
    }
}