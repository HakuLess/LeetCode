package leetcode.contest.cur.leetcode.c220

class Solution5630 {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var ans = Int.MIN_VALUE
        val l = ArrayList<Int>()
        var cur = 0
        for (i in nums.indices) {
            while (l.contains(nums[i])) {
                cur -= l[0]
                l.removeAt(0)
            }
            l.add(nums[i])
            cur += nums[i]
            ans = maxOf(ans, cur)
        }
        return ans
    }
}