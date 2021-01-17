package leetcode.contest.cur.leetcode.c224

class Solution5243 {
    fun tupleSameProduct(nums: IntArray): Int {
        val p = HashMap<Int, Int>()
        for (i in 0 until nums.lastIndex) {
            for (j in i + 1 until nums.size) {
                val key = nums[i] * nums[j]
                p[key] = p.getOrDefault(key, 0) + 1
            }
        }
        var ans = 0
        p.forEach {
            ans += (it.value * (it.value - 1)) * 4
        }
        return ans
    }
}